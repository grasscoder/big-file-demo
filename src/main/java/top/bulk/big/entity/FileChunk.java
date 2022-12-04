package top.bulk.big.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 文件块存储(FileChunk)表实体类
 *
 * @author 散装java
 * @since 2022-11-19 14:59:08
 */
@Data
public class FileChunk implements Serializable {
    /**主键**/
    private Long id;
    /**文件名**/
    private String fileName;
    /**当前分片，从1开始**/
    private Integer chunkNumber;
    /**分片大小**/
    private Long chunkSize;
    /**当前分片大小**/
    private Long currentChunkSize;
    /**文件总大小**/
    private Long totalSize;
    /**总分片数**/
    private Integer totalChunk;
    /**文件标识 md5校验码**/
    private String identifier;
    /**相对路径**/
    private String relativePath;

    /**创建者**/
    private String createBy;
    /**创建时间**/
    private LocalDateTime createTime;
    /**更新人**/
    private String updateBy;
    /**更新时间**/
    private LocalDateTime updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getChunkNumber() {
        return chunkNumber;
    }

    public void setChunkNumber(Integer chunkNumber) {
        this.chunkNumber = chunkNumber;
    }

    public Long getChunkSize() {
        return chunkSize;
    }

    public void setChunkSize(Long chunkSize) {
        this.chunkSize = chunkSize;
    }

    public Long getCurrentChunkSize() {
        return currentChunkSize;
    }

    public void setCurrentChunkSize(Long currentChunkSize) {
        this.currentChunkSize = currentChunkSize;
    }

    public Long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }

    public Integer getTotalChunk() {
        return totalChunk;
    }

    public void setTotalChunk(Integer totalChunk) {
        this.totalChunk = totalChunk;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}

