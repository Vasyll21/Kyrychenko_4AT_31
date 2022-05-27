package task_17.models;

import java.lang.reflect.Array;
import java.util.Objects;

public class CreateTaskResponse {
    //{
    //      "attachments":[],
    //      "stickers":[],
    //      "id":"628a3cadef56c54e83dc8e24",
    //      "badges":{
    //              "attachmentsByType":{
    //                  "trello":{
    //                      "board":0,
    //                      "card":0
    //                  }
    //              },
    //              "location":false,
    //              "votes":0,
    //              "viewingMemberVoted":false,
    //              "subscribed":false,
    //              "fogbugz":"",
    //              "checkItems":0,
    //              "checkItemsChecked":0,
    //              "checkItemsEarliestDue":null,
    //              "comments":0,
    //              "attachments":0,
    //              "description":false,
    //              "due":null,
    //              "dueComplete":false,
    //              "start":null
    //      },
    //      "checkItemStates":[],
    //      "closed":false,
    //      "dueComplete":false,
    //      "dateLastActivity":"2022-05-22T13:37:49.131Z",
    //      "desc":"",
    //      "descData":{
    //          "emoji":{}
    //      },
    //      "due":null,
    //      "dueReminder":null,
    //      "email":null,
    //      "idBoard":"628a3cabfcb7c08c32f8dfd9",
    //      "idChecklists":[],
    //      "idList":"628a3cac1845737adf0eba89",
    //      "idMembers":[],
    //      "idMembersVoted":[],
    //      "idShort":1,
    //      "idAttachmentCover":null,
    //      "labels":[],
    //      "idLabels":[],
    //      "manualCoverAttachment":false,
    //      "name":"Task",
    //      "pos":16384,
    //      "shortLink":"d5H0NymV",
    //      "shortUrl":"https://trello.com/c/d5H0NymV",
    //      "start":null,
    //      "subscribed":false,
    //      "url":"https://trello.com/c/d5H0NymV/1-task",
    //      "cover":{
    //          "idAttachment":null,
    //          "color":null,
    //          "idUploadedBackground":null,
    //          "size":"normal",
    //          "brightness":"dark",
    //          "idPlugin":null
    //      },
    //      "isTemplate":false,
    //      "cardRole":null,
    //      "limits":{}
    //}

    private String id;
    private Object badges;
    private Boolean closed;
    private Boolean dueComplete;
    private String dateLastActivity;
    private String desc;
    private Object descData;
    private String due;
    private String dueReminder;
    private String email;
    private String idBoard;
    private String idList;
    private Integer idShort;
    private String idAttachmentCover;
    private Boolean manualCoverAttachment;
    private String name;
    private Integer pos;
    private String shortLink;
    private String shortUrl;
    private String start;
    private Boolean subscribed;
    private String url;
    private Object cover;
    private Boolean isTemplate;
    private String cardRole;
    private Object limits;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getBadges() {
        return badges;
    }

    public void setBadges(Object badges) {
        this.badges = badges;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public Boolean getDueComplete() {
        return dueComplete;
    }

    public void setDueComplete(Boolean dueComplete) {
        this.dueComplete = dueComplete;
    }

    public String getDateLastActivity() {
        return dateLastActivity;
    }

    public void setDateLastActivity(String dateLastActivity) {
        this.dateLastActivity = dateLastActivity;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getDescData() {
        return descData;
    }

    public void setDescData(Object descData) {
        this.descData = descData;
    }

    public String getDue() {
        return due;
    }

    public void setDue(String due) {
        this.due = due;
    }

    public String getDueReminder() {
        return dueReminder;
    }

    public void setDueReminder(String dueReminder) {
        this.dueReminder = dueReminder;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdBoard() {
        return idBoard;
    }

    public void setIdBoard(String idBoard) {
        this.idBoard = idBoard;
    }

    public String getIdList() {
        return idList;
    }

    public void setIdList(String idList) {
        this.idList = idList;
    }

    public Integer getIdShort() {
        return idShort;
    }

    public void setIdShort(Integer idShort) {
        this.idShort = idShort;
    }

    public String getIdAttachmentCover() {
        return idAttachmentCover;
    }

    public void setIdAttachmentCover(String idAttachmentCover) {
        this.idAttachmentCover = idAttachmentCover;
    }

    public Boolean getManualCoverAttachment() {
        return manualCoverAttachment;
    }

    public void setManualCoverAttachment(Boolean manualCoverAttachment) {
        this.manualCoverAttachment = manualCoverAttachment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

    public String getShortLink() {
        return shortLink;
    }

    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public Boolean getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(Boolean subscribed) {
        this.subscribed = subscribed;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getCover() {
        return cover;
    }

    public void setCover(Object cover) {
        this.cover = cover;
    }

    public Boolean getTemplate() {
        return isTemplate;
    }

    public void setTemplate(Boolean template) {
        isTemplate = template;
    }

    public String getCardRole() {
        return cardRole;
    }

    public void setCardRole(String cardRole) {
        this.cardRole = cardRole;
    }

    public Object getLimits() {
        return limits;
    }

    public void setLimits(Object limits) {
        this.limits = limits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateTaskResponse that = (CreateTaskResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(badges, that.badges) && Objects.equals(closed, that.closed) && Objects.equals(dueComplete, that.dueComplete) && Objects.equals(dateLastActivity, that.dateLastActivity) && Objects.equals(desc, that.desc) && Objects.equals(descData, that.descData) && Objects.equals(due, that.due) && Objects.equals(dueReminder, that.dueReminder) && Objects.equals(email, that.email) && Objects.equals(idBoard, that.idBoard) && Objects.equals(idList, that.idList) && Objects.equals(idShort, that.idShort) && Objects.equals(idAttachmentCover, that.idAttachmentCover) && Objects.equals(manualCoverAttachment, that.manualCoverAttachment) && Objects.equals(name, that.name) && Objects.equals(pos, that.pos) && Objects.equals(shortLink, that.shortLink) && Objects.equals(shortUrl, that.shortUrl) && Objects.equals(start, that.start) && Objects.equals(subscribed, that.subscribed) && Objects.equals(url, that.url) && Objects.equals(cover, that.cover) && Objects.equals(isTemplate, that.isTemplate) && Objects.equals(cardRole, that.cardRole) && Objects.equals(limits, that.limits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, badges, closed, dueComplete, dateLastActivity, desc, descData, due, dueReminder, email, idBoard, idList, idShort, idAttachmentCover, manualCoverAttachment, name, pos, shortLink, shortUrl, start, subscribed, url, cover, isTemplate, cardRole, limits);
    }

    @Override
    public String toString() {
        return "CreateTaskResponse{" +
                "id='" + id + '\'' +
                ", badges=" + badges +
                ", closed=" + closed +
                ", dueComplete=" + dueComplete +
                ", dateLastActivity='" + dateLastActivity + '\'' +
                ", desc='" + desc + '\'' +
                ", descData=" + descData +
                ", due='" + due + '\'' +
                ", dueReminder='" + dueReminder + '\'' +
                ", email='" + email + '\'' +
                ", idBoard='" + idBoard + '\'' +
                ", idList='" + idList + '\'' +
                ", idShort=" + idShort +
                ", idAttachmentCover='" + idAttachmentCover + '\'' +
                ", manualCoverAttachment=" + manualCoverAttachment +
                ", name='" + name + '\'' +
                ", pos=" + pos +
                ", shortLink='" + shortLink + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                ", start='" + start + '\'' +
                ", subscribed=" + subscribed +
                ", url='" + url + '\'' +
                ", cover=" + cover +
                ", isTemplate=" + isTemplate +
                ", cardRole='" + cardRole + '\'' +
                ", limits=" + limits +
                '}';
    }
}
