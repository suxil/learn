package com.learn.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Title:
 * Description:
 * date: 2020/1/1 19:37
 *
 * @author suxi
 * @version V1.0
 */
@ApiModel(value="岗位树对象")
public class UaaPositionTreeDto implements Serializable {

    private String id;

    @ApiModelProperty(name = "parent_id", value = "父岗位id")
    private String parentId;

    @ApiModelProperty(name = "seq", value = "序号")
    private Integer seq;

    @ApiModelProperty(name = "level", value = "岗位层级")
    private Integer level;

    @ApiModelProperty(name = "position_code", value = "岗位代码")
    private String positionCode;

    @ApiModelProperty(name = "position_name", value = "岗位名称")
    private String positionName;

    @ApiModelProperty(name = "children", value = "子节点")
    private List<UaaPositionTreeDto> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public List<UaaPositionTreeDto> getChildren() {
        return children;
    }

    public void setChildren(List<UaaPositionTreeDto> children) {
        this.children = children;
    }
}
