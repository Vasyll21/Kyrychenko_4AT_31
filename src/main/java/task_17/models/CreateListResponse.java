package task_17.models;

import java.util.Objects;

public class CreateListResponse {
    private String id;
    private String name;
    private Boolean closed;
    private String idBoard;
    private Integer pos;
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

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public String getIdBoard() {
        return idBoard;
    }

    public void setIdBoard(String idBoard) {
        this.idBoard = idBoard;
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

    public Object getLimits() {
        return limits;
    }

    public void setLimits(Object limits) {
        this.limits = limits;
    }

    @Override
    public String toString() {
        return "CreateListResponse{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", closed=" + closed +
                ", idBoard='" + idBoard + '\'' +
                ", pos=" + pos +
                ", limits=" + limits +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateListResponse that = (CreateListResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(closed, that.closed) && Objects.equals(idBoard, that.idBoard) && Objects.equals(pos, that.pos) && Objects.equals(limits, that.limits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, closed, idBoard, pos, limits);
    }
}
