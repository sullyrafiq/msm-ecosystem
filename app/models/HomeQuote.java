package models;

/**
 * Created with IntelliJ IDEA.
 * User: opeyemi.ajayi
 * Date: 27/03/14
 * Time: 20:44
 * To change this template use File | Settings | File Templates.
 */
public class HomeQuote {

    private String policyType;

    private double premium;

    private boolean includesLegalCover;

    private boolean includesEmergencyCover;

    private boolean includesNewForOld;

    private double excess;

    public String getPolicyType() {
        return policyType;
    }

    public double getPremium() {
        return premium;
    }

    public boolean isIncludesLegalCover() {
        return includesLegalCover;
    }

    public boolean isIncludesEmergencyCover() {
        return includesEmergencyCover;
    }

    public boolean isIncludesNewForOld() {
        return includesNewForOld;
    }

    public double getExcess() {
        return excess;
    }

    public HomeQuote(String policyType, double premium, boolean includesLegalCover, boolean includesEmergencyCover, boolean includesNewForOld, double excess) {
        this.policyType = policyType;
        this.premium = premium;
        this.includesLegalCover = includesLegalCover;
        this.includesEmergencyCover = includesEmergencyCover;
        this.includesNewForOld = includesNewForOld;
        this.excess = excess;
    }
}
