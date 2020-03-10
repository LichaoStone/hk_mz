$(document).ready(function() {
	// 初始化表单验证信息
	$("#form").bootstrapValidator({
		excluded: [':disabled', ':hidden', ':not(:visible)'],
		message : '',
		feedbackIcons : {
		},
		submitHandler: function (validator,form,submitButton) {
			//上映时间
		    form.attr("action", basePath+"/tvplayEpisode/update_tvplayEpisode.do?");
			validator.defaultSubmit();
		},
		fields : {
			episodeName : {
				validators : {
					notEmpty : {
						message : '子集名称不能为空'
					}
				}
			},
			episodeNum : {
				validators : {
					notEmpty : {
						message : '当前集数不能为空'
					},
					regexp: {
						regexp:   /^[0-9]*[1-9][0-9]*$/,
						message: '当前集数只能为大于0的正整数'
					}
				}
			}
		}
	});
});

/**
 * 重置按钮校验
 */
function cancelData(){
	resetForm();
}


/**
 * 重置校验
 */
function resetForm(){
	$("#form").data('bootstrapValidator').resetForm();
}

