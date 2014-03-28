package models;

/**
 * Created with IntelliJ IDEA.
 * User: opeyemi.ajayi
 * Date: 27/03/14
 * Time: 19:18
 * To change this template use File | Settings | File Templates.
 */
public class InsuranceQuote {

    private final String coverType;

    private final double premium;

    private final String logoUrl;

    private final String detailsUrl;

    private final String provider;

    public String getCoverType() {
        return coverType;
    }

    public double getPremium() {
        return premium;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public String getDetailsUrl() {
        return detailsUrl;
    }

    public String getProvider() {
        return provider;
    }

    public InsuranceQuote(String coverType, double premium, String provider, String logoUrl, String detailsUrl) {
        this.provider = provider;
        this.coverType = coverType;
        this.premium = premium;
        this.logoUrl = logoUrl;
        this.detailsUrl = detailsUrl;
    }
}
