package com.cybertek.library.pojos;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    private String id;

    @SerializedName("full_name")
    private String fullName;

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    @SerializedName("user_group_id")
    private String userGroupId;

    @SerializedName("image")
    private Object image;

    @SerializedName("extra_data")
    private Object extraData;

    @SerializedName("status")
    private String status;

    @SerializedName("is_admin")
    private String isAdmin;

    @SerializedName("start_date")
    private String startDate;

    @SerializedName("end_date")
    private String endDate;

    @SerializedName("address")
    private String address;

    /**
     * No args constructor for use in serialization
     *
     */
    public User() {
    }

    /**
     *
     * @param userGroupId
     * @param image
     * @param password
     * @param address
     * @param extraData
     * @param endDate
     * @param fullName
     * @param id
     * @param isAdmin
     * @param email
     * @param startDate
     * @param status
     */
    public User(String id, String fullName, String email, String password, String userGroupId, Object image, Object extraData, String status, String isAdmin, String startDate, String endDate, String address) {
        super();
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.userGroupId = userGroupId;
        this.image = image;
        this.extraData = extraData;
        this.status = status;
        this.isAdmin = isAdmin;
        this.startDate = startDate;
        this.endDate = endDate;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userGroupId='" + userGroupId + '\'' +
                ", image=" + image +
                ", extraData=" + extraData +
                ", status='" + status + '\'' +
                ", isAdmin='" + isAdmin + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(String userGroupId) {
        this.userGroupId = userGroupId;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
        this.image = image;
    }

    public Object getExtraData() {
        return extraData;
    }

    public void setExtraData(Object extraData) {
        this.extraData = extraData;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
