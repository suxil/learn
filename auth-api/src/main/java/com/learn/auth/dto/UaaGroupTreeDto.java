package com.learn.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Title:
 * Description:
 * date: 2020/1/1 19:28
 *
 * @author suxi
 * @version V1.0
 */
@ApiModel(value="组树对象")
public class UaaGroupTreeDto implements Serializable {

    private String id;

    @ApiModelProperty(name = "parent_id", value = "父组id")
    private String parentId;

    @ApiModelProperty(name = "seq", value = "序号")
    private Integer seq;

    @ApiModelProperty(name = "level", value = "组层级")
    private Integer level;

    @ApiModelProperty(name = "group_code", value = "组代码")
    private String groupCode;

    @ApiModelProperty(name = "group_name", value = "组名称")
    private String groupName;

    @ApiModelProperty(name = "children", value = "子节点")
    private List<UaaGroupTreeDto> children;

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

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<UaaGroupTreeDto> getChildren() {
        return children;
    }

    public void setChildren(List<UaaGroupTreeDto> children) {
        this.children = children;
    }
}
