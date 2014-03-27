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

    public String getCoverType() {
        return coverType;
    }

    public double getPremium() {
        return premium;
    }

    public InsuranceQuote(String coverType, double premium) {

        this.coverType = coverType;
        this.premium = premium;

    }
}
