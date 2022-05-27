package task_17.models;

import java.util.Comparator;
import java.util.Objects;

public class CreateBoardResponse {
//{"id":"62853a8d37e44d2b37b1f281",
//  "name":"Board_1",
//  "desc":"",
//  "descData":null,
//  "closed":false,
//  "idOrganization":"6280f6da3eb5cf83ed278586",
//  "idEnterprise":null,
//  "pinned":false,
//  "url":"https://trello.com/b/kqHUXECm/board1",
//  "shortUrl":"https://trello.com/b/kqHUXECm",
//  "prefs":{
//    "permissionLevel":"private",
//    "hideVotes":false,
//    "voting":"disabled",
//    "comments":"members",
//    "invitations":"members",
//    "selfJoin":true,
//    "cardCovers":true,
//    "isTemplate":false,
//    "cardAging":"regular",
//    "calendarFeedEnabled":false,
//    "hiddenPluginBoardButtons":[],
//    "background":"blue",
//    "backgroundColor":"#0079BF",
//    "backgroundImage":null,
//    "backgroundImageScaled":null,
//    "backgroundTile":false,
//    "backgroundBrightness":"dark",
//    "backgroundBottomColor":"#0079BF",
//    "backgroundTopColor":"#0079BF",
//    "canBePublic":true,
//    "canBeEnterprise":true,
//    "canBeOrg":true,
//    "canBePrivate":true,
//    "canInvite":true
//  },
//  "labelNames":{
//    "green":"",
//    "yellow":"",
//    "orange":"",
//    "red":"",
//    "purple":"",
//    "blue":"",
//    "sky":"",
//    "lime":"",
//    "pink":"",
//    "black":""
//  },
//  "limits":{}
//}

    private String id;
    private String name;
    private String desc;
    private String descData;
    private Boolean closed;
    private String idOrganization;
    private String idEnterprise;
    private Boolean pinned;
    private String url;
    private String shortUrl;
    private Object prefs;
    private Object labelNames;
    private Object limits;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDescData() {
        return descData;
    }

    public void setDescData(String descData) {
        this.descData = descData;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public String getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
    }

    public String getIdEnterprise() {
        return idEnterprise;
    }

    public void setIdEnterprise(String idEnterprise) {
        this.idEnterprise = idEnterprise;
    }

    public Boolean getPinned() {
        return pinned;
    }

    public void setPinned(Boolean pinned) {
        this.pinned = pinned;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public Object getPrefs() {
        return prefs;
    }

    public void setPrefs(Object prefs) {
        this.prefs = prefs;
    }

    public Object getLabelNames() {
        return labelNames;
    }

    public void setLabelNames(Object labelNames) {
        this.labelNames = labelNames;
    }

    public Object getLimits() {
        return limits;
    }

    public void setLimits(Object limits) {
        this.limits = limits;
    }

    @Override
    public String toString() {
        return "CreateBoardResponse{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", descData='" + descData + '\'' +
                ", closed=" + closed +
                ", idOrganization='" + idOrganization + '\'' +
                ", idEnterprise='" + idEnterprise + '\'' +
                ", pinned=" + pinned +
                ", url='" + url + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                ", prefs=" + prefs +
                ", labelNames=" + labelNames +
                ", limits=" + limits +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateBoardResponse that = (CreateBoardResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(desc, that.desc) && Objects.equals(descData, that.descData) && Objects.equals(closed, that.closed) && Objects.equals(idOrganization, that.idOrganization) && Objects.equals(idEnterprise, that.idEnterprise) && Objects.equals(pinned, that.pinned);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, desc, descData, closed, idOrganization, idEnterprise, pinned);
    }
}
