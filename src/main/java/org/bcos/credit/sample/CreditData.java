package org.bcos.credit.sample;

import org.fisco.bcos.web3j.abi.datatypes.generated.Int256;

import java.math.BigInteger;
import java.util.List;

public class CreditData {
    private List<String> signatures;
    private String companyName;
    private String nameHash;
    private List<String> publicKeys;//证据生效需要的公钥列表
    private BigInteger grade;
    private Boolean pledge;
    private BigInteger companyValue;
    private String addBorrow;
    private String addMortgage;

    public CreditData(List<String> signatures, String companyName, String nameHash, List<String> publicKeys, BigInteger grade, Boolean pledge, BigInteger companyValue, String addB, String addM) {
        this.signatures = signatures;
        this.companyName = companyName;
        this.nameHash = nameHash;
        this.publicKeys = publicKeys;
        this.grade = grade;
        this.pledge = pledge;
        this.companyValue = companyValue;
        this.addBorrow = addB;
        this.addMortgage = addM;
    }
    public CreditData() {

    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getNameHash() {
        return nameHash;
    }

    public void setNameHash(String nameHash) {
        this.nameHash = nameHash;
    }

    public List<String> getSignatures() {
        return signatures;
    }

    public void setSignatures(List<String> signatures) {
        this.signatures = signatures;
    }

    public List<String> getPublicKeys() {
        return publicKeys;
    }

    public void setPublicKeys(List<String> publicKeys) {
        this.publicKeys = publicKeys;
    }

    public BigInteger getGrade() {
        return grade;
    }

    public void setGrade(BigInteger grade) {
        this.grade = grade;
    }

    public Boolean getPledge() {
        return pledge;
    }

    public void setPledge(Boolean pledge) {
        this.pledge = pledge;
    }

    public BigInteger getCompanyValue() {
        return companyValue;
    }

    public void setCompanyValue(BigInteger companyValue) {
        this.companyValue = companyValue;
    }

    public String getAddBorrow() {
        return addBorrow;
    }

    public void setAddBorrow(String addB) {
        this.addBorrow = addB;
    }

    public String getAddMortgage() {
        return addMortgage;
    }

    public void setAddMortgage(String addM) {
        this.addMortgage = addM;
    }
}
