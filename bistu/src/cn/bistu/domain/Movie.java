//package com.sample;
package com.sample;

import java.util.Date;

public class Movie {

  private Integer movieId;
  private Integer year;
  private String title;
  private Double maoyanPeople;
  private Double taopiaopiaoPeople;
  private Double doubanPeople;
  private Double maoyanScore;
  private Double taopiaopiaoScore;
  private Double doubanScore;
  private Double duration;
  private String actor;
//  private Double actorNum;
  private String screenwriter;
//  private Double screenwriterNum;
  private String synopsis;
  private String director;
//  private Double directorVar1;
//  private Double directorVar2;
//  private Double directorVar3;
//  private Double directorVar4;
  private String publisher;
//  private Double publisherVar1;
//  private Double publisherVar2;
//  private Double publisherVar3;
//  private Double publisherVar4;
  private String executiveProducer;
//  private Double executiveProducerVar1;
//  private Double executiveProducerVar2;
//  private Double executiveProducerVar3;
//  private Double executiveProducerVar4;
  private String producer;
//  private Double producerVar1;
//  private Double producerVar2;
//  private Double producerVar3;
//  private Double producerVar4;
  private String productionCompany;
//  private Double productionCompanyVar1;
//  private Double productionCompanyVar2;
//  private Double productionCompanyVar3;
//  private Double productionCompanyVar4;
  private String manufacturingCompany;
//  private Double manufacturingCompanyVar1;
//  private Double manufacturingCompanyVar2;
//  private Double manufacturingCompanyVar3;
//  private Double manufacturingCompanyVar4;
  private String distributionCompany;
//  private Double distributionCompanyVar1;
//  private Double distributionCompanyVar2;
//  private Double distributionCompanyVar3;
//  private Double distributionCompanyVar4;
  private String integratedMarketingCompany;
//  private Double integratedMarketingCompanyVar1;
//  private Double integratedMarketingCompanyVar2;
//  private Double integratedMarketingCompanyVar3;
//  private Double integratedMarketingCompanyVar4;
  private String newMediaMarketingCompany;
//  private Double newMediaMarketingCompanyVar1;
//  private Double newMediaMarketingCompanyVar2;
//  private Double newMediaMarketingCompanyVar3;
//  private Double newMediaMarketingCompanyVar4;
  private Long isSeries;
  private Long isSequel;
//  @JSONField(format = "yyyy-MM-dd")
  private Date releaseDate;
  private String schedule;
  private String mainType;
  private String completeType;
  private String format;
  private String country;
  private String investment;
  private String property;
  private Double annualBoxoffice;
  private Double totalBoxoffice;
  private Double annualSession;
  private Double totalSession;
  private Double annualPeople;
  private Double totalPeople;
  private Double firstweakBoxoffice;
  private Double avgPrice;
  private Double avgPeople;
  private String titleEn;
  private Double weeksShareOfBoxoffice;
  private Double serveFee;
  private String mainActor;
  private Long synopsisNum;
  private Integer typeNum;
  private String type1;
  private String type2;
  private String type3;
  private String ipId;

  @Override
  public String toString() {
    return "Movie{" +
            "title='" + title + '\'' +
            ", actor='" + actor + '\'' +
            ", director='" + director + '\'' +
            ", totalBoxoffice=" + totalBoxoffice +
            '}';
  }

  public Movie() {
  }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getMaoyanPeople() {
        return maoyanPeople;
    }

    public void setMaoyanPeople(Double maoyanPeople) {
        this.maoyanPeople = maoyanPeople;
    }

    public Double getTaopiaopiaoPeople() {
        return taopiaopiaoPeople;
    }

    public void setTaopiaopiaoPeople(Double taopiaopiaoPeople) {
        this.taopiaopiaoPeople = taopiaopiaoPeople;
    }

    public Double getDoubanPeople() {
        return doubanPeople;
    }

    public void setDoubanPeople(Double doubanPeople) {
        this.doubanPeople = doubanPeople;
    }

    public Double getMaoyanScore() {
        return maoyanScore;
    }

    public void setMaoyanScore(Double maoyanScore) {
        this.maoyanScore = maoyanScore;
    }

    public Double getTaopiaopiaoScore() {
        return taopiaopiaoScore;
    }

    public void setTaopiaopiaoScore(Double taopiaopiaoScore) {
        this.taopiaopiaoScore = taopiaopiaoScore;
    }

    public Double getDoubanScore() {
        return doubanScore;
    }

    public void setDoubanScore(Double doubanScore) {
        this.doubanScore = doubanScore;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getScreenwriter() {
        return screenwriter;
    }

    public void setScreenwriter(String screenwriter) {
        this.screenwriter = screenwriter;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getExecutiveProducer() {
        return executiveProducer;
    }

    public void setExecutiveProducer(String executiveProducer) {
        this.executiveProducer = executiveProducer;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getProductionCompany() {
        return productionCompany;
    }

    public void setProductionCompany(String productionCompany) {
        this.productionCompany = productionCompany;
    }

    public String getManufacturingCompany() {
        return manufacturingCompany;
    }

    public void setManufacturingCompany(String manufacturingCompany) {
        this.manufacturingCompany = manufacturingCompany;
    }

    public String getDistributionCompany() {
        return distributionCompany;
    }

    public void setDistributionCompany(String distributionCompany) {
        this.distributionCompany = distributionCompany;
    }

    public String getIntegratedMarketingCompany() {
        return integratedMarketingCompany;
    }

    public void setIntegratedMarketingCompany(String integratedMarketingCompany) {
        this.integratedMarketingCompany = integratedMarketingCompany;
    }

    public String getNewMediaMarketingCompany() {
        return newMediaMarketingCompany;
    }

    public void setNewMediaMarketingCompany(String newMediaMarketingCompany) {
        this.newMediaMarketingCompany = newMediaMarketingCompany;
    }

    public Long getIsSeries() {
        return isSeries;
    }

    public void setIsSeries(Long isSeries) {
        this.isSeries = isSeries;
    }

    public Long getIsSequel() {
        return isSequel;
    }

    public void setIsSequel(Long isSequel) {
        this.isSequel = isSequel;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getMainType() {
        return mainType;
    }

    public void setMainType(String mainType) {
        this.mainType = mainType;
    }

    public String getCompleteType() {
        return completeType;
    }

    public void setCompleteType(String completeType) {
        this.completeType = completeType;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getInvestment() {
        return investment;
    }

    public void setInvestment(String investment) {
        this.investment = investment;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Double getAnnualBoxoffice() {
        return annualBoxoffice;
    }

    public void setAnnualBoxoffice(Double annualBoxoffice) {
        this.annualBoxoffice = annualBoxoffice;
    }

    public Double getTotalBoxoffice() {
        return totalBoxoffice;
    }

    public void setTotalBoxoffice(Double totalBoxoffice) {
        this.totalBoxoffice = totalBoxoffice;
    }

    public Double getAnnualSession() {
        return annualSession;
    }

    public void setAnnualSession(Double annualSession) {
        this.annualSession = annualSession;
    }

    public Double getTotalSession() {
        return totalSession;
    }

    public void setTotalSession(Double totalSession) {
        this.totalSession = totalSession;
    }

    public Double getAnnualPeople() {
        return annualPeople;
    }

    public void setAnnualPeople(Double annualPeople) {
        this.annualPeople = annualPeople;
    }

    public Double getTotalPeople() {
        return totalPeople;
    }

    public void setTotalPeople(Double totalPeople) {
        this.totalPeople = totalPeople;
    }

    public Double getFirstweakBoxoffice() {
        return firstweakBoxoffice;
    }

    public void setFirstweakBoxoffice(Double firstweakBoxoffice) {
        this.firstweakBoxoffice = firstweakBoxoffice;
    }

    public Double getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(Double avgPrice) {
        this.avgPrice = avgPrice;
    }

    public Double getAvgPeople() {
        return avgPeople;
    }

    public void setAvgPeople(Double avgPeople) {
        this.avgPeople = avgPeople;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public Double getWeeksShareOfBoxoffice() {
        return weeksShareOfBoxoffice;
    }

    public void setWeeksShareOfBoxoffice(Double weeksShareOfBoxoffice) {
        this.weeksShareOfBoxoffice = weeksShareOfBoxoffice;
    }

    public Double getServeFee() {
        return serveFee;
    }

    public void setServeFee(Double serveFee) {
        this.serveFee = serveFee;
    }

    public String getMainActor() {
        return mainActor;
    }

    public void setMainActor(String mainActor) {
        this.mainActor = mainActor;
    }

    public Long getSynopsisNum() {
        return synopsisNum;
    }

    public void setSynopsisNum(Long synopsisNum) {
        this.synopsisNum = synopsisNum;
    }

    public Integer getTypeNum() {
        return typeNum;
    }

    public void setTypeNum(Integer typeNum) {
        this.typeNum = typeNum;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getType3() {
        return type3;
    }

    public void setType3(String type3) {
        this.type3 = type3;
    }

    public String getIpId() {
        return ipId;
    }

    public void setIpId(String ipId) {
        this.ipId = ipId;
    }
}
