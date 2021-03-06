/*

 License GNU: https://github.com/danielcebrian/rangeslider-videojs/blob/master/License-GNU.rst
 License Apache: https://github.com/danielcebrian/rangeslider-videojs/blob/master/License-Apache.rst

 @date 2018-09-02
 @author zx
 @Description:vedio.js 插件
 */
//----------------Load Plugin----------------//

_vjs4 = {
    on : function (element, eventName, func, flag) {
        element.addEventListener(eventName, func, flag);
    },
    off : function (element, eventName, func, flag) {
        element.removeEventListener(eventName, func, flag);
    },
    addClass : function (element, className) {
        element.classList.add(className);
    },
    removeClass : function (element, className) {
        element.classList.remove(className);
    },
    findPosition : function (element) {
        return element.getBoundingClientRect();
    },
    round : function (n, precision) {
        return parseFloat(n.toFixed(precision));
    },
    blockTextSelection : function () {
        // TODO
    }
};

(function () {
    function getYoutubeError(error_int){
        var _langErrors = {
            // invalid-params
            2: 'The request contains an invalid parameter value. For example, this error occurs if you specify a video ID that does not have 11 characters, or if the video ID contains invalid characters, such as exclamation points or asterisks.',
            // html5-error
            5: 'The requested content cannot be played in an HTML5 player or another error related to the HTML5 player has occurred.',
            // video not found
            100: 'The video requested was not found. This error occurs when a video has been removed (for any reason) or has been marked as private.',
            // embed not allowed
            101: 'The owner of the requested video does not allow it to be played in embedded players.',
            // embed not allowed
            150: 'The owner of the requested video does not allow it to be played in embedded players.'
        };

        return _langErrors[error_int] === undefined ? "Unknown Error" : _langErrors[error_int];
    }

    //-- Load RangeSlider plugin in videojs
    function RangeSlider_(options) {
        var player = this;

        player.rangeslider = new RangeSlider(player, options);

        //When the DOM and the video media is loaded
        function initialVideoFinished(event) {
            var plugin = player.rangeslider;
            //All components will be initialize after they have been loaded by videojs
            for (var index in plugin.components) {
                plugin.components[index].init_();
            }

            if (plugin.options.hidden)
                plugin.hide(); //Hide the Range Slider

            if (plugin.options.locked)
                plugin.lock(); //Lock the Range Slider

            if (plugin.options.panel === false)
                plugin.hidePanel(); //Hide the second Panel

            if (plugin.options.controlTime === false)
                plugin.hidecontrolTime(); //Hide the control time panel

            //plugin._reset();
            plugin._reset5();	//自定义初始化
            player.trigger('loadedRangeSlider'); //Let know if the Range Slider DOM is ready
        }
        if (player.techName == 'Youtube') {
            //Detect youtube problems
            player.one('error', function (e) {
                alert(getYoutubeError(player.error));
            });
            player.on('firstplay', initialVideoFinished);
        } else {
            player.one('playing', initialVideoFinished);
        }

    }
    
    videojs.plugin('rangeslider', RangeSlider_);

    //-- Plugin
    function RangeSlider(_player, options) {
        
        var player = _player || this;
        this.player = player;

        this.components = {}; // holds any custom components we add to the player

        options = options || {}; // plugin options

        if (!options.hasOwnProperty('locked'))
            options.locked = false; // lock slider handles

        if (!options.hasOwnProperty('hidden'))
            options.hidden = true; // hide slider handles

        if (!options.hasOwnProperty('panel'))
            options.panel = true; // Show Second Panel

        if (!options.hasOwnProperty('controlTime'))
            options.controlTime = true; // Show Control Time to set the arrows in the edition

        this.options = options;

        this.init();
    }

//-- Methods
    RangeSlider.prototype = {
        /*Constructor*/
        init: function () {
            var player = this.player || {};

            this.updatePrecision = 3;

            //position in second of the arrows
            this.start = 0;
            this.end = 0;

            //components of the plugin
            var controlBar = player.controlBar;
            var seekBar = controlBar.progressControl.seekBar;
            this.components.RSTimeBar = seekBar.RSTimeBar;
            this.components.ControlTimePanel = controlBar.ControlTimePanel;

            //Save local component
            this.rstb = this.components.RSTimeBar;
            this.box = this.components.SeekRSBar = this.rstb.SeekRSBar;
            this.bar = this.components.SelectionBar = this.box.SelectionBar;
            this.left = this.components.SelectionBarLeft = this.box.SelectionBarLeft;
            this.right = this.components.SelectionBarRight = this.box.SelectionBarRight;
            this.tp = this.components.TimePanel = this.box.TimePanel;
            this.tpl = this.components.TimePanelLeft = this.tp.TimePanelLeft;
            this.tpr = this.components.TimePanelRight = this.tp.TimePanelRight;
            this.ctp = this.components.ControlTimePanel;
            this.ctpl = this.components.ControlTimePanelLeft = this.ctp.ControlTimePanelLeft;
            this.ctpr = this.components.ControlTimePanelRight = this.ctp.ControlTimePanelRight;
            
            this.weitiao=false;
        },
        lock: function () {
            this.options.locked = true;
            this.ctp.enable(false);
            if (typeof this.box != 'undefined')
                _vjs4.addClass(this.box.el_, 'locked');
        },
        unlock: function () {
            this.options.locked = false;
            this.ctp.enable();
            if (typeof this.box != 'undefined')
                _vjs4.removeClass(this.box.el_, 'locked');
        },
        //显示seakbar，剪辑控件
        showbox: function() {
            if (typeof this.box != 'undefined')
                this.box.show();
		},
		//隐藏seakbar，剪辑控件
		hidebox: function() {
            if (typeof this.box != 'undefined')
                this.box.hide();
		},
        show: function () {
            this.options.hidden = false;
            if (typeof this.rstb != 'undefined') {
                this.rstb.show();
                if (this.options.controlTime)
                    this.showcontrolTime();
            }
        },
        hide: function () {
            this.options.hidden = true;
            if (typeof this.rstb != 'undefined') {
                this.rstb.hide();
                this.ctp.hide();
            }
        },
        showPanel: function () {
            this.options.panel = true;
            if (typeof this.tp != 'undefined')
                _vjs4.removeClass(this.tp.el_, 'disable');
        },
        hidePanel: function () {
            this.options.panel = false;
            if (typeof this.tp != 'undefined')
                _vjs4.addClass(this.tp.el_, 'disable');
        },
        showcontrolTime: function () {
            this.options.controlTime = true;
            if (typeof this.ctp != 'undefined')
                this.ctp.show();
        },
        hidecontrolTime: function () {
            this.options.controlTime = false;
            if (typeof this.ctp != 'undefined')
                this.ctp.hide();
        },
        setValue: function (index, seconds, writeControlTime,init) {
            //index = 0 for the left Arrow and 1 for the right Arrow. Value in seconds
            writeControlTime = typeof writeControlTime != 'undefined' ? writeControlTime : true;

            var percent = this._percent(seconds);
            var isValidIndex = (index === 0 || index === 1);
            var isChangeable = !this.locked;
            if (isChangeable && isValidIndex)
                this.box.setPosition(index, percent, writeControlTime);
            
            if(init != undefined)
            this.player.currentTime(seconds);
        },
        setValues: function (start, end, writeControlTime) {
            //index = 0 for the left Arrow and 1 for the right Arrow. Value in seconds
            writeControlTime = typeof writeControlTime != 'undefined' ? writeControlTime : true;

            this._reset();

            this._setValuesLocked(start, end, writeControlTime);
        },
        getValues: function () { //get values in seconds
            var values = {}, start, end;
            start = this.start || this._getArrowValue(0);
            end = this.end || this._getArrowValue(1);
            return {start: start, end: end};
        },
        playBetween: function (start, end, showRS) {
            showRS = typeof showRS == 'undefined' ? true : showRS;
            this.player.currentTime(start);
            this.player.play();
            if (showRS) {
                this.show();
                this._reset();
            } else {
                this.hide();
            }
            this._setValuesLocked(start, end);

            this.bar.activatePlay(start, end);
        },
        loop: function (start, end, show) {
            var player = this.player;

            if (player) {
                player.on("pause", videojs.bind(this, function () {
                    this.looping = false;
                }));

                show = typeof show === 'undefined' ? true : show;

                if (show) {
                    this.show();
                    this._reset();
                }
                else {
                    this.hide();
                }
                this._setValuesLocked(start, end);

                this.timeStart = start;
                this.timeEnd = end;
                this.looping = true;

                this.player.currentTime(start);
                this.player.play();

                this.player.on("timeupdate", videojs.bind(this, this.bar.process_loop));
            }
        },
        _getArrowValue: function (index) {
            index = index || 0;
            var duration = this.player.duration();

            duration = typeof duration == 'undefined' ? 0 : duration;

            var percentage = this[index === 0 ? "left" : "right"].el_.style.left.replace("%", "");
            if (percentage === "")
                percentage = index === 0 ? 0 : 100;

            return _vjs4.round(this._seconds(percentage / 100), this.updatePrecision - 1);
        },
        _percent: function (seconds) {
            var duration = this.player.duration();
            if (isNaN(duration)) {
                return 0;
            }
            return Math.min(1, Math.max(0, seconds / duration));
        },
        _seconds: function (percent) {
            var duration = this.player.duration();
            if (isNaN(duration)) {
                return 0;
            }
            return Math.min(duration, Math.max(0, percent * duration));
        },
        _reset: function () {
            var duration = this.player.duration();

            this._setValuesLocked(0, duration);
        },
        _reset5:function(){
            var duration = this.player.duration();

            this._setInitValues(0, duration);
        },
        //原型设计：结束漏斗按钮与其间隔在总时长1/5的位置上，以便于用户一眼就明白如何操作
        _setInitValues:function(start,end){
            var triggerSliderChange = typeof writeControlTime != 'undefined';
            writeControlTime = typeof writeControlTime != 'undefined' ? writeControlTime : true;
            if (this.options.locked) {
                this.unlock();//It is unlocked to change the bar position. In the end it will return the value.
                this.setValue(0, start, writeControlTime);
                this.setValue(1, end * 0.2, writeControlTime);
                this.lock();
            } else {
                this.setValue(0, start, writeControlTime);
                this.setValue(1, end * 0.2, writeControlTime);
            }

            // Trigger slider change
            if (triggerSliderChange) {
                this._triggerSliderChange();
            }
        },
        
        _setValuesLocked: function (start, end, writeControlTime) {
            var triggerSliderChange = typeof writeControlTime != 'undefined';
            writeControlTime = typeof writeControlTime != 'undefined' ? writeControlTime : true;
            if (this.options.locked) {
                this.unlock();//It is unlocked to change the bar position. In the end it will return the value.
                this.setValue(0, start, writeControlTime);
                this.setValue(1, end, writeControlTime);
                this.lock();
            } else {
                this.setValue(0, start, writeControlTime);
                this.setValue(1, end, writeControlTime);
            }

            // Trigger slider change
            if (triggerSliderChange) {
                this._triggerSliderChange();
            }
        },

        _parseCueTime: function(times) {
            var timeArr = times.split(":");
            
            var seconds =   parseInt(timeArr[0] * 60 * 60)
                            + parseInt(timeArr[1] * 60)
                                + parseInt(timeArr[2]);
            return seconds;
            
        },

        _checkControlTime: function (index, TextInput) {
            var h = TextInput.h,
                    m = TextInput.m,
                    s = TextInput.s,
                    newHour = h,
                    newMin = m,
                    newSec = s,
                    obj, objNew, objOld;
            index = index || 0;

            var duration = this.player.duration() || 0,
                    durationSel;

            var intRegex = /^\d+$/;//check if the objNew is an integer
            if (!intRegex.test(objNew) || objNew > 60) {
                objNew = objNew === "" ? "" : objOld;
            }

            newHour = newHour === "" ? 0 : newHour;
            newMin = newMin === "" ? 0 : newMin;
            newSec = newSec === "" ? 0 : newSec;

            durationSel = this._parseCueTime(newHour + ":" + newMin + ":" + newSec);
            /*
            if (durationSel > duration) {
                obj = objOld;
                //obj.style.border = "1px solid red";
            } else {
                obj = objNew;
                //h.style.border = m.style.border = s.style.border = "1px solid transparent";
                this.setValue(index, durationSel, false);

                // Trigger slider change
                this._triggerSliderChange();
            }
            */
           this.setValue(index, durationSel, false,false);

           // Trigger slider change
           this._triggerSliderChange();
                      
        },
        _triggerSliderChange: function () {
            this.player.trigger("sliderchange");
        },
        //微调使能
        setEnable: function(enable) {
			this.ctpl.enable = this.ctpr.enable = enable;
		},
    };


//----------------Public Functions----------------//

//-- Public Functions added to video-js

    var videojsPlayer = videojs.getComponent('Player');

    // Add compatibility functions
    videojsPlayer.prototype._v4 = _vjs4;

//Lock the Slider bar and it will not be possible to change the arrow positions
    videojsPlayer.prototype.lockSlider = function () {
        return this.rangeslider.lock();
    };

//Unlock the Slider bar and it will be possible to change the arrow positions
    videojsPlayer.prototype.unlockSlider = function () {
        return this.rangeslider.unlock();
    };

//Show the Slider Bar Component
    videojsPlayer.prototype.showSlider = function () {
        return this.rangeslider.show();
    };

//Hide the Slider Bar Component
    videojsPlayer.prototype.hideSlider = function () {
        return this.rangeslider.hide();
    };

//Show the Panel with the seconds of the selection
    videojsPlayer.prototype.showSliderPanel = function () {
        return this.rangeslider.showPanel();
    };

//Hide the Panel with the seconds of the selection
    videojsPlayer.prototype.hideSliderPanel = function () {
        return this.rangeslider.hidePanel();
    };


//Show the control Time to edit the position of the arrows
    videojsPlayer.prototype.showControlTime = function () {
        return this.rangeslider.showcontrolTime();
    };

//Hide the control Time to edit the position of the arrows
    videojsPlayer.prototype.hideControlTime = function () {
        return this.rangeslider.hidecontrolTime();
    };

//Set a Value in second for both arrows
    videojsPlayer.prototype.setValueSlider = function (start, end) {
        return this.rangeslider.setValues(start, end);
    };
    
//The video will be played in a selected section
    videojsPlayer.prototype.playBetween = function (start, end) {
        return this.rangeslider.playBetween(start, end);
    };

//The video will loop between to values
    videojsPlayer.prototype.loopBetween = function (start, end) {
        return this.rangeslider.loop(start, end);
    };

//Set a Value in second for the arrows
    videojsPlayer.prototype.getValueSlider = function () {
        return this.rangeslider.getValues();
    };
    //时长
    videojsPlayer.prototype.getDuration = function(duration) {
    	return videojs.formatTime()
	};
	//
	videojsPlayer.prototype.hideSeakbar = function(duration) {
    	return this.rangeslider.hidebox()
	};
	videojsPlayer.prototype.showSeakbar = function(duration) {
    	return this.rangeslider.showbox()
	};
	
	videojsPlayer.prototype.micrEnable = function(enable){
		return this.rangeslider.setEnable(enable)
	}

//----------------Create new Components----------------//

//--Charge the new Component into videojs
    var videojsSeekBar = videojs.getComponent('SeekBar');
    videojsSeekBar.prototype.options_.children.push('RSTimeBar'); //Range Slider Time Bar

    var videojsControlBar = videojs.getComponent('ControlBar');
    videojsControlBar.prototype.options_.children.push('ControlTimePanel'); //Panel with the time of the range slider



//-- Design the new components

    var videojsComponent = videojs.getComponent('Component');

    /**
     * Range Slider Time Bar
     * @param {videojs.Player|Object} player
     * @param {Object=} options
     * @constructor
     */
    var videojsRSTimeBar = videojs.extend(videojsComponent, {
        /** @constructor */
        constructor: function (player, options) {
            videojsComponent.call(this, player, options);
        }
    });

    videojsRSTimeBar.prototype.init_ = function () {
        this.rs = this.player_.rangeslider;
    };

    videojsRSTimeBar.prototype.options_ = {
        children: {
            'SeekRSBar': {}
        }
    };

    videojsRSTimeBar.prototype.createEl = function () {
        return videojsComponent.prototype.createEl.call(this, 'div', {
            className: 'vjs-timebar-RS',
            innerHTML: ''
        });
    };

    videojs.registerComponent('RSTimeBar', videojsRSTimeBar);

    /**
     * Seek Range Slider Bar and holder for the selection bars
     * @param {videojs.Player|Object} player
     * @param {Object=} options
     * @constructor
     */
    var videojsSeekRSBar = videojs.extend(videojsComponent, {
        /** @constructor */
        constructor: function (player, options) {
            videojsComponent.call(this, player, options);
            this.on('mousedown', this.onMouseDown);
        }
    });

    videojsSeekRSBar.prototype.init_ = function () {
        this.rs = this.player_.rangeslider;
    };

    videojsSeekRSBar.prototype.options_ = {
        children: {
            'SelectionBar': {},
            'SelectionBarLeft': {},
            'SelectionBarRight': {},
            'TimePanel': {},
        }
    };

    videojsSeekRSBar.prototype.createEl = function () {
        return videojsComponent.prototype.createEl.call(this, 'div', {
            className: 'vjs-rangeslider-holder'
        });
    };


    videojsSeekRSBar.prototype.onMouseDown = function (event) {
        event.preventDefault();
        _vjs4.blockTextSelection();

        if (!this.rs.options.locked) {
            _vjs4.on(document, "mousemove", videojs.bind(this, this.onMouseMove));
            _vjs4.on(document, "mouseup", videojs.bind(this, this.onMouseUp));
        }
    };

    videojsSeekRSBar.prototype.onMouseUp = function (event) {
        _vjs4.off(document, "mousemove", this.onMouseMove, false);
        _vjs4.off(document, "mouseup", this.onMouseUp, false);
    };

    videojsSeekRSBar.prototype.onMouseMove = function (event) {
        var left = this.calculateDistance(event);

        if (this.rs.left.pressed)
            this.setPosition(0, left);
        else if (this.rs.right.pressed)
            this.setPosition(1, left);

        //Fix a problem with the presition in the display time
        var ctd = this.player_.controlBar.currentTimeDisplay;
        //if currentTimeDisplay do not register ,will case error
        if (ctd) {
        	ctd.contentEl_.innerHTML = '<span class="vjs-control-text">' + ctd.localize('Current Time') + '</span>' + videojs.formatTime(this.rs._seconds(left), this.player_.duration());
        }

        // Trigger slider change
        if (this.rs.left.pressed || this.rs.right.pressed) {
            this.rs._triggerSliderChange();
        }
    };

    /**
     * 
     * @param {*} index 
     * @param {*} left 
     * @param {*} writeControlTime 
     */
    videojsSeekRSBar.prototype.setPosition = function (index, left, writeControlTime) {
        writeControlTime = typeof writeControlTime != 'undefined' ? writeControlTime : true;
        //index = 0 for left side, index = 1 for right side
        index = index || 0;

        // Position shouldn't change when handle is locked
        if (this.rs.options.locked)
            return false;

        // Check for invalid position
        if (isNaN(left))
            return false;

        // Check index between 0 and 1
        if (!(index === 0 || index === 1))
            return false;
        // Alias
        var ObjLeft = this.rs.left.el_,
                ObjRight = this.rs.right.el_,
                Obj = this.rs[index === 0 ? 'left' : 'right'].el_,
                tpr = this.rs.tpr.el_,
                tpl = this.rs.tpl.el_,
                bar = this.rs.bar,
                ctp = this.rs[index === 0 ? 'ctpl' : 'ctpr'];
        
        //Check if left arrow is passing the right arrow
        if ((index === 0 ? bar.updateLeft(left) : bar.updateRight(left))) {
            
            Obj.style.left = (left * 100) + '%';
            
            if (index === 0) { 
                bar.updateLeft(left); 
            }else{
                bar.updateRight(left);
            }

            this.rs[index === 0 ? 'start' : 'end'] = this.rs._seconds(left);

            //Fix the problem  when you press the button and the two arrow are underhand
            //left.zIndex = 10 and right.zIndex=20. This is always less in this case:
            if (index === 0) {
                if ((left) >= 0.9)
                    ObjLeft.style.zIndex = 25;
                else
                    ObjLeft.style.zIndex = 10;
            }

            //-- Panel
            var TimeText = videojs.formatTime(this.rs._seconds(left)),
                    tplTextLegth = tpl.children[0].innerHTML.length;
            var MaxP, MinP, MaxDisP;
            if (tplTextLegth <= 4) //0:00
                MaxDisP = this.player_.isFullScreen ? 3.25 : 6.5;
            else if (tplTextLegth <= 5)//00:00
                MaxDisP = this.player_.isFullScreen ? 4 : 8;
            else//0:00:00
                MaxDisP = this.player_.isFullScreen ? 5 : 10;
            if (TimeText.length <= 4) { //0:00
                MaxP = this.player_.isFullScreen ? 97 : 93;
                MinP = this.player_.isFullScreen ? 0.1 : 0.5;
            } else if (TimeText.length <= 5) {//00:00
                MaxP = this.player_.isFullScreen ? 96 : 92;
                MinP = this.player_.isFullScreen ? 0.1 : 0.5;
            } else {//0:00:00
                MaxP = this.player_.isFullScreen ? 95 : 91;
                MinP = this.player_.isFullScreen ? 0.1 : 0.5;
            }

            if (index === 0) {
                tpl.style.left = Math.max(MinP, Math.min(MaxP, (left * 100 - MaxDisP / 2))) + '%';

                if ((tpr.style.left.replace("%", "") - tpl.style.left.replace("%", "")) <= MaxDisP)
                    tpl.style.left = Math.max(MinP, Math.min(MaxP, tpr.style.left.replace("%", "") - MaxDisP)) + '%';
                tpl.children[0].innerHTML = TimeText;
            } else {
                tpr.style.left = Math.max(MinP, Math.min(MaxP, (left * 100 - MaxDisP / 2))) + '%';

                if (((tpr.style.left.replace("%", "") || 100) - tpl.style.left.replace("%", "")) <= MaxDisP)
                    tpr.style.left = Math.max(MinP, Math.min(MaxP, tpl.style.left.replace("%", "") - 0 + MaxDisP)) + '%';
                tpr.children[0].innerHTML = TimeText;
            }

            //-- 设置微调组件时间值
            if (writeControlTime) {
                var time = TimeText.split(":"),
                        h, m, s;
                if (time.length == 2) {
                    h = 0;
                    m = time[0];
                    s = time[1];
                } else {
                    h = time[0];
                    m = time[1];
                    s = time[2];
                }
                ctp.timeVal.h = h;
                ctp.timeVal.m = m;
                ctp.timeVal.s = s;
            }
        }
        
        return true;
    };

    videojsSeekRSBar.prototype.calculateDistance = function (event) {
        var rstbX = this.getRSTBX();
        var rstbW = this.getRSTBWidth();
        var handleW = this.getWidth();

        // Adjusted X and Width, so handle doesn't go outside the bar
        rstbX = rstbX + (handleW / 2);
        rstbW = rstbW - handleW;

        // Percent that the click is through the adjusted area
        return Math.max(0, Math.min(1, (event.pageX - rstbX) / rstbW));
    };

    videojsSeekRSBar.prototype.getRSTBWidth = function () {
        return this.el_.offsetWidth;
    };
    videojsSeekRSBar.prototype.getRSTBX = function () {
        return _vjs4.findPosition(this.el_).left;
    };
    videojsSeekRSBar.prototype.getWidth = function () {
        return this.rs.left.el_.offsetWidth;//does not matter left or right
    };

    videojs.registerComponent('SeekRSBar', videojsSeekRSBar);


    /**
     * This is the bar with the selection of the RangeSlider
     * @param {videojs.Player|Object} player
     * @param {Object=} options
     * @constructor
     */
    var videojsSelectionBar = videojs.extend(videojsComponent, {
        /** @constructor */
        constructor: function (player, options) {
            videojsComponent.call(this, player, options);
            this.on('mouseup', this.onMouseUp);
            this.fired = false;
        }
    });

    videojsSelectionBar.prototype.init_ = function () {
        this.rs = this.player_.rangeslider;
    };

    videojsSelectionBar.prototype.createEl = function () {
        return videojsComponent.prototype.createEl.call(this, 'div', {
            className: 'vjs-selectionbar-RS'
        });
    };

    videojsSelectionBar.prototype.onMouseUp = function () {
        var start = this.rs.left.el_.style.left.replace("%", ""),
                end = this.rs.right.el_.style.left.replace("%", ""),
                duration = this.player_.duration(),
                precision = this.rs.updatePrecision,
                segStart = _vjs4.round(start * duration / 100, precision),
                segEnd = _vjs4.round(end * duration / 100, precision);
        this.player_.currentTime(segStart);
        this.player_.play();
        this.rs.bar.activatePlay(segStart, segEnd);
    };

    videojsSelectionBar.prototype.updateLeft = function (left) {
        var rightVal = this.rs.right.el_.style.left !== '' ? this.rs.right.el_.style.left : 100;
        var right = parseFloat(rightVal) / 100;

        var width = _vjs4.round((right - left), this.rs.updatePrecision); //round necessary for not get 0.6e-7 for example that it's not able for the html css width

        //(right+0.00001) is to fix the precision of the css in html
        if (left <= (right + 0.00001)) {
            this.rs.bar.el_.style.left = (left * 100) + '%';
            this.rs.bar.el_.style.width = (width * 100) + '%';
            return true;
        }
        return false;
    };

    videojsSelectionBar.prototype.updateRight = function (right) {
        var leftVal = this.rs.left.el_.style.left !== '' ? this.rs.left.el_.style.left : 0;
        var left = parseFloat(leftVal) / 100;

        var width = _vjs4.round((right - left), this.rs.updatePrecision);//round necessary for not get 0.6e-7 for example that it's not able for the html css width

        //(right+0.00001) is to fix the precision of the css in html
        if ((right + 0.00001) >= left) {
            this.rs.bar.el_.style.width = (width * 100) + '%';
            this.rs.bar.el_.style.left = ((right - width) * 100) + '%';
            return true;
        }
        return false;
    };

    videojsSelectionBar.prototype.activatePlay = function (start, end) {
        this.timeStart = start;
        this.timeEnd = end;

        this.suspendPlay();

        this.player_.on("timeupdate", videojs.bind(this, this._processPlay));
    };

    videojsSelectionBar.prototype.suspendPlay = function () {
        this.fired = false;
        this.player_.off("timeupdate", videojs.bind(this, this._processPlay));
    };

    videojsSelectionBar.prototype._processPlay = function () {
        //Check if current time is between start and end
        if (this.player_.currentTime() >= this.timeStart && (this.timeEnd < 0 || this.player_.currentTime() < this.timeEnd)) {
            if (this.fired) { //Do nothing if start has already been called
                return;
            }
            this.fired = true; //Set fired flag to true
        } else {
            if (!this.fired) { //Do nothing if end has already been called
                return;
            }
            this.fired = false; //Set fired flat to false
            this.player_.pause(); //Call end function
            this.player_.currentTime(this.timeEnd);
            this.suspendPlay();
        }
    };

    videojsSelectionBar.prototype.process_loop = function () {
        var player = this.player;

        if (player && this.looping) {
            var current_time = player.currentTime();

            if (current_time < this.timeStart || this.timeEnd > 0 && this.timeEnd < current_time) {
                player.currentTime(this.timeStart);
            }
        }
    };

    videojs.registerComponent('SelectionBar', videojsSelectionBar);

    /**
     * This is the left arrow to select the RangeSlider
     * @param {videojs.Player|Object} player
     * @param {Object=} options
     * @constructor
     */
    var videojsSelectionBarLeft = videojs.extend(videojsComponent, {
        /** @constructor */
        constructor: function (player, options) {
            videojsComponent.call(this, player, options);
            this.on('mousedown', this.onMouseDown);
            this.pressed = false;
        }
    });

    videojsSelectionBarLeft.prototype.init_ = function () {
        this.rs = this.player_.rangeslider;
    };

    videojsSelectionBarLeft.prototype.createEl = function () {
        return videojsComponent.prototype.createEl.call(this, 'div', {
            className: 'vjs-rangeslider-handle vjs-selectionbar-left-RS',
            innerHTML: '<div class="vjs-selectionbar-arrow-RS"></div><div class="vjs-selectionbar-line-RS"></div>'
        });
    };

    videojsSelectionBarLeft.prototype.onMouseDown = function (event) {
        event.preventDefault();
        _vjs4.blockTextSelection();
        if (!this.rs.options.locked) {
            this.pressed = true;
            _vjs4.on(document, "mouseup", videojs.bind(this, this.onMouseUp));
            _vjs4.addClass(this.el_, 'active');
        }
    };

    videojsSelectionBarLeft.prototype.onMouseUp = function (event) {
        _vjs4.off(document, "mouseup", this.onMouseUp, false);
        _vjs4.removeClass(this.el_, 'active');
        if (!this.rs.options.locked) {
            this.pressed = false;
        }
    };

    videojs.registerComponent('SelectionBarLeft', videojsSelectionBarLeft);


    /**
     * This is the right arrow to select the RangeSlider
     * @param {videojs.Player|Object} player
     * @param {Object=} options
     * @constructor
     */
    var videojsSelectionBarRight = videojs.extend(videojsComponent, {
        /** @constructor */
        constructor: function (player, options) {
            videojsComponent.call(this, player, options);
            this.on('mousedown', this.onMouseDown);
            this.pressed = false;
        }
    });

    videojsSelectionBarRight.prototype.init_ = function () {
        this.rs = this.player_.rangeslider;
    };

    videojsSelectionBarRight.prototype.createEl = function () {
        return videojsComponent.prototype.createEl.call(this, 'div', {
            className: 'vjs-rangeslider-handle vjs-selectionbar-right-RS',
            innerHTML: '<div class="vjs-selectionbar-arrow-RS"></div><div class="vjs-selectionbar-line-RS"></div>'
        });
    };


    videojsSelectionBarRight.prototype.onMouseDown = function (event) {
        event.preventDefault();
        _vjs4.blockTextSelection();
        if (!this.rs.options.locked) {
            this.pressed = true;
            _vjs4.on(document, "mouseup", videojs.bind(this, this.onMouseUp));
            _vjs4.addClass(this.el_, 'active');
        }
    };

    videojsSelectionBarRight.prototype.onMouseUp = function (event) {
        _vjs4.off(document, "mouseup", this.onMouseUp, false);
        _vjs4.removeClass(this.el_, 'active');
        if (!this.rs.options.locked) {
            this.pressed = false;
        }
    };

    videojs.registerComponent('SelectionBarRight', videojsSelectionBarRight);

    /**
     * This is the time panel
     * @param {videojs.Player|Object} player
     * @param {Object=} options
     * @constructor
     */
    var videojsTimePanel = videojs.extend(videojsComponent, {
        /** @constructor */
        constructor: function (player, options) {
            videojsComponent.call(this, player, options);
        }
    });

    videojsTimePanel.prototype.init_ = function () {
        this.rs = this.player_.rangeslider;
    };

    videojsTimePanel.prototype.options_ = {
        children: {
            'TimePanelLeft': {},
            'TimePanelRight': {},
        }
    };

    videojsTimePanel.prototype.createEl = function () {
        return videojsComponent.prototype.createEl.call(this, 'div', {
            className: 'vjs-timepanel-RS'
        });
    };

    videojs.registerComponent('TimePanel', videojsTimePanel);

    /**
     * This is the left time panel
     * @param {videojs.Player|Object} player
     * @param {Object=} options
     * @constructor
     */
    var videojsTimePanelLeft = videojs.extend(videojsComponent, {
        /** @constructor */
        constructor: function (player, options) {
            videojsComponent.call(this, player, options);
        }
    });

    videojsTimePanelLeft.prototype.init_ = function () {
        this.rs = this.player_.rangeslider;
    };

    videojsTimePanelLeft.prototype.createEl = function () {
        return videojsComponent.prototype.createEl.call(this, 'div', {
            className: 'vjs-timepanel-left-RS',
            innerHTML: '<span class="vjs-time-text">00:00</span>'
        });
    };

    videojs.registerComponent('TimePanelLeft', videojsTimePanelLeft);


    /**
     * This is the right time panel
     * @param {videojs.Player|Object} player
     * @param {Object=} options
     * @constructor
     */
    var videojsTimePanelRight = videojs.extend(videojsComponent, {
        /** @constructor */
        constructor: function (player, options) {
            videojsComponent.call(this, player, options);
        }
    });

    videojsTimePanelRight.prototype.init_ = function () {
        this.rs = this.player_.rangeslider;
    };

    videojsTimePanelRight.prototype.createEl = function () {
        return videojsComponent.prototype.createEl.call(this, 'div', {
            className: 'vjs-timepanel-right-RS',
            innerHTML: '<span class="vjs-time-text">00:00</span>'
        });
    };

    videojs.registerComponent('TimePanelRight', videojsTimePanelRight);

    /**
     * This is the control time panel
     * @param {videojs.Player|Object} player
     * @param {Object=} options
     * @constructor
     */
    var videojsControlTimePanel = videojs.extend(videojsComponent, {
        /** @constructor */
        constructor: function (player, options) {
            videojsComponent.call(this, player, options);
        }
    });

    videojsControlTimePanel.prototype.init_ = function () {
        this.rs = this.player_.rangeslider;
    };


    videojsControlTimePanel.prototype.options_ = {
        children: {
            'ControlTimePanelLeft': {},
            'ControlLabelPanel':{},
            'ControlTimePanelRight': {},
        }
    };

    videojsControlTimePanel.prototype.createEl = function () {
        return videojsComponent.prototype.createEl.call(this, 'ul', {
            className: 'micro-operation',
        });
    };

    videojsControlTimePanel.prototype.enable = function (enable) {
        enable = typeof enable != 'undefined' ? enable : true;
        //this.rs.ctpl.el_.children[0].disabled = enable ? "" : "disabled";
        //this.rs.ctpl.el_.children[1].disabled = enable ? "" : "disabled";
        //this.rs.ctpl.el_.children[2].disabled = enable ? "" : "disabled";

    };

    videojs.registerComponent('ControlTimePanel', videojsControlTimePanel);

    /**
     * This is the control left time panel
     * @param {videojs.Player|Object} player
     * @param {Object=} options
     * @constructor
     */
    var videojsControlTimePanelLeft = videojs.extend(videojsComponent, {
        /** @constructor */
        constructor: function (player, options) {
            videojsComponent.call(this, player, options);
            this.on('mouseup', this.onMouseUp);
            this.on('mousedown', this.onMouseDown);
        }
    });

    videojsControlTimePanelLeft.prototype.init_ = function () {
        this.rs = this.player_.rangeslider;
        //时间控制
        this.timeVal = {h:0,m:0,s:0};
        //事件响应控制
        this.enable =true;
    };

    videojsControlTimePanelLeft.prototype.createEl = function () {
        return videojsComponent.prototype.createEl.call(this, 'li', {
            className: 'micro-clip',
            innerHTML: '<span id="start-left"></span><span class="left-mark"></span><span id="start-right"></span>',
        });
    };

    videojsControlTimePanelLeft.prototype.onMouseDown = function (event) {
    	if(!this.player_.paused() || !this.enable){
    		return;
    	}
    	var time=this.player_.rangeslider.ctpr.timeVal;
    	var timeright = parseInt(time.h) * 60 * 60 + parseInt(time.m) * 60 + parseInt(time.s);
    	var thisTime = parseInt(this.timeVal.h) * 60 * 60 + parseInt(this.timeVal.m) * 60 + parseInt(this.timeVal.s);
    	
    	switch (event.target.id) {
		case "start-left":
			
			//左边减小
        	if(thisTime > 0){
                if(--this.timeVal.s < 0){
                    if(thisTime < 60){
                    	this.timeVal.s=0;
                    }
                    else if(thisTime >= 60 && thisTime < 3600){
                    	this.timeVal.m--;
                    	this.timeVal.s =59;
                    }else if(thisTime >= 3600){
                        if(thisTime % 3600 == 0){
                        	this.timeVal.m=59;
                        	this.timeVal.s =59;
                        	this.timeVal.h = --this.timeVal.h<0?0:this.timeVal.h;
                        }else if(thisTime % 60 == 0){
                            this.timeVal.m--;
                            this.timeVal.s =59;
                        }
                    }
                }
            }
			break;
		case "start-right":
			if(timeright > thisTime && ++this.timeVal.s == 60){
				this.timeVal.s = 0;				
				if(++this.timeVal.m == 60){
					this.timeVal.m = 0;
					this.timeVal.h++;
				}
			}
			break;
		case "end-left":

			break;
		case "end-right":

			break;
		default:
			break;
		}

    };

    videojsControlTimePanelLeft.prototype.onMouseUp = function (event) {
    	if(!this.player_.paused() || !this.enable){
    		return;
    	}
        this.rs._checkControlTime(0, this.timeVal);
    };

    videojs.registerComponent('ControlTimePanelLeft', videojsControlTimePanelLeft);

    /**
     * This is the control left time panel
     * @param {videojs.Player|Object} player
     * @param {Object=} options
     * @constructor
     */
    var videojsControlTimePanelRight = videojs.extend(videojsComponent, {
        /** @constructor */
        constructor: function (player, options) {
            videojsComponent.call(this, player, options);
            this.on('mouseup', this.onMouseUp);
            this.on('mousedown', this.onMouseDown);
        }
    });

    videojsControlTimePanelRight.prototype.init_ = function () {
        this.rs = this.player_.rangeslider;
        //时间控制
        this.timeVal = {h:0,m:0,s:0};
        //事件响应控制
        this.enable =true;
    };

    videojsControlTimePanelRight.prototype.createEl = function () {
        return videojsComponent.prototype.createEl.call(this, 'li', {
            className: 'micro-clip',
            innerHTML:'<span id="end-left"></span><span class="right-mark"></span><span id="end-right"></span>',
        });
    };

    videojsControlTimePanelRight.prototype.onMouseDown = function (event) {
    	//满足暂停和微调使能两个条件
    	if(!this.player_.paused() || !this.enable){
    		return;
    	}
    	var time=this.player_.rangeslider.ctpl.timeVal;
    	var timeleft = parseInt(time.h) * 60 * 60 + parseInt(time.m) * 60 + parseInt(time.s);
    	var thisTime = parseInt(this.timeVal.h) * 60 * 60 + parseInt(this.timeVal.m) * 60 + parseInt(this.timeVal.s);
    	switch (event.target.id) {
		case "start-right":

			break;
		case "start-left":			

			break;
        case "end-left":
        	//先判断是否小于左边剪辑值        	
        	if(thisTime > timeleft && thisTime > 0){
                if(--this.timeVal.s < 0){
                    if(thisTime < 60){
                    	this.timeVal.s=0;
                    }
                    else if(thisTime >= 60 && thisTime < 3600){
                    	this.timeVal.m--;
                    	this.timeVal.s =59;
                    }else if(thisTime >= 3600){
                    	this.timeVal.s =59;
                        if(thisTime % 3600 == 0){
                        	this.timeVal.m=59;
                        	this.timeVal.h = --this.timeVal.h<0?0:this.timeVal.h;
                        }else if(thisTime % 60 == 0){
                        	this.timeVal.m--;
                        	this.timeVal.s =59;
                        }
                    }
                }
            }

			break;
		case "end-right":

			if(thisTime < this.player_.duration()){
	            if(++this.timeVal.s == 60){
	                this.timeVal.s = 0;                
	                if(++this.timeVal.m == 60){
	                    this.timeVal.m = 0;
	                    this.timeVal.h++;
	                }
	            }
			}

			break;
		default:
			break;
		}

    };

    videojsControlTimePanelRight.prototype.onMouseUp = function (event) {
    	//满足暂停和微调使能两个条件
    	if(!this.player_.paused() || !this.enable){
    		return;
    	}
        this.rs._checkControlTime(1, this.timeVal);
    };

    videojs.registerComponent('ControlTimePanelRight', videojsControlTimePanelRight);


    /**
     * This is the control left time panel
     * @param {videojs.Player|Object} player
     * @param {Object=} options
     * @constructor
     */
    var videojsControlLabelPanel = videojs.extend(videojsComponent, {
        /** @constructor */
        constructor: function (player, options) {
            videojsComponent.call(this, player, options);
        }
    });

    videojsControlLabelPanel.prototype.init_ = function () {
        this.rs = this.player_.rangeslider;
    };

    videojsControlLabelPanel.prototype.createEl = function () {
        return videojsComponent.prototype.createEl.call(this, 'li', {
            className: 'micro-clip weitiao',
            //innerHTML:'<span>微调</span>',
            innerHTML:'',
        });
    };

    videojs.registerComponent('ControlLabelPanel', videojsControlLabelPanel);
})();
