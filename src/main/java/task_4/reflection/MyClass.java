package task_4.reflection;

public class MyClass {
    private String field1;
    private Integer field2;
    private Integer field3;

    public MyClass(String field1, Integer field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public MyClass() {
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public Integer getField2() {
        return field2;
    }

    public void setField2(Integer field2) {
        this.field2 = field2;
    }

    public Integer getField3() {
        return field3;
    }

    public void setField3(Integer field3) {
        this.field3 = field3;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "field1='" + field1 + '\'' +
                ", field2=" + field2 +
                ", field3=" + field3 +
                '}';
    }
}
