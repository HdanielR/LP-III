//Interface para a classe Data
public interface DataInterface{
    void setDate(int day, int month, int year);
    void setCurrentDate();
    boolean isPrevious(int day, int month, int year);
    boolean isPrevious(Data outraData);
    int howManyDays(int day, int month, int year);
    int howManyDays(Data outraData);
    public String dayOfWeek(Data date);
    String toStringShort();
    String toStringLong();
}
