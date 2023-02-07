package Bean;

public class PersonData {
    private Integer id;
    private Integer statisticYear;
    private String according;
    private String siteId;
    private String sex;
    private Double averageAge;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatisticYear() {
        return statisticYear;
    }

    public void setStatisticYear(Integer statisticYear) {
        this.statisticYear = statisticYear;
    }

    public String getAccording() {
        return according;
    }

    public void setAccording(String according) {
        this.according = according;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Double getAverageAge() {
        return averageAge;
    }

    public void setAverageAge(Double averageAge) {
        this.averageAge = averageAge;
    }
}
