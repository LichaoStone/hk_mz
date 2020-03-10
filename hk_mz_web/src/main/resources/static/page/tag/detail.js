$(document).ready(function() {
	showTagList();
	
	
});

/**
 * 显示标签列表
 * @returns
 */
function showTagList() {
	  $.ajax({
	        url: `${basePath}tag/list/${tagType}`,
	        type: 'POST',
	        dataType:"json",
	        success : function(data) {
	            if (data.ok == true) {
	            	document.querySelector(".tag").addEventListener("drag", dragStart, false);
	            } else {
	            	toast(data.message,true,'error','top',400);
	            }
	        }
	    });
}

function dragStart (event) {
    let e = event.touches ? event.touches[0] : event

    this.zIndex = 2

    this.shiftX = this.shiftStartX = this.left
    this.shiftY = this.shiftStartY = this.top

    this.mouseMoveStartX = e.pageX
    this.mouseMoveStartY = e.pageY

    this.animate = false
    this.dragging = true

    document.addEventListener('mousemove', this.documentMouseMove)
    document.addEventListener('touchmove', this.documentMouseMove)

  }
function drag (event) {
    let e = event.touches ? event.touches[0] : event

    let distanceX = e.pageX - this.mouseMoveStartX
    let distanceY = e.pageY - this.mouseMoveStartY

    this.shiftX = distanceX + this.shiftStartX
    this.shiftY = distanceY + this.shiftStartY

    let gridX = Math.round(this.shiftX / this.cellWidth)
    let gridY = Math.round(this.shiftY / this.cellHeight)

    gridX = Math.min(gridX, this.rowCount - 1)
    gridY = Math.max(gridY, 0)

    let gridPosition = gridX + gridY * this.rowCount

    const $event = {
      event,
      distanceX,
      distanceY,
      positionX: this.shiftX,
      positionY: this.shiftY,
      index: this.index,
      gridX,
      gridY,
      gridPosition
    }

    this.$emit('drag', $event)
  }