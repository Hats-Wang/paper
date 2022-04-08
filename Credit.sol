pragma solidity ^0.4.4;
contract CreditSignersDataABI{ function verify(address addr)public constant returns(bool){}
function getSigner(uint index)public constant returns(address){} 
function getSignersSize() public constant returns(uint){}
}

import "./Borrow.sol";

contract Credit{
    
    int256 grade;
    string companyName;
    bool pledge;
    int256 value;
    uint8[] _v;
    bytes32[] _r;
    bytes32[] _s;
    address[] signers;
    address public signersAddr;
    address addBorrow;
    address addMortgage;

        event addSignaturesEvent(int256 grd, string name, bool p, int256 vl, uint8 v, bytes32 r, bytes32 s);
        event newSignaturesEvent(int256 grd, string name, bool p, int256 vl, uint8 v, bytes32 r, bytes32 s,address addr);
        event errorNewSignaturesEvent(int256 grd, string name, bool p, int256 vl, uint8 v, bytes32 r, bytes32 s,address addr);
        event errorAddSignaturesEvent(int256 grd, string name, bool p, int256 vl, uint8 v, bytes32 r, bytes32 s,address addr);
        event addRepeatSignaturesEvent(int256 grd, string name, bool p, int256 vl, uint8 v, bytes32 r, bytes32 s);
        event errorRepeatSignaturesEvent(int256 grd, string name, bool p, int256 vl, uint8 v, bytes32 r, bytes32 s, address addr);

    function CallVerify(address addr) public constant returns(bool) {
        return CreditSignersDataABI(signersAddr).verify(addr);
    }

    function Credit(int256 grd, string name, bool p, int256 vl, uint8 v, bytes32 r, bytes32 s, address addr, address sender) public {
       signersAddr = addr;
       if(CallVerify(sender))
       {
           grade = grd;
           companyName = name;
           pledge = p;
           value = vl;
           addBorrow = address(0);
           addMortgage = address(0);
           _v.push(v);
           _r.push(r);
           _s.push(s);
           signers.push(sender);
           emit newSignaturesEvent(grd,name,p,vl,v,r,s,addr);
       }
       else
       {
           emit errorNewSignaturesEvent(grd,name,p,vl,v,r,s,addr);
       }
    }


    function getCredit() public constant returns(int256,string,bool,int256,uint8[],bytes32[],bytes32[],address[],address,address){
        uint length = CreditSignersDataABI(signersAddr).getSignersSize();
         address[] memory signerList = new address[](length);
         for(uint i= 0 ;i<length ;i++)
         {
             signerList[i] = (CreditSignersDataABI(signersAddr).getSigner(i));
         }
         int256 g = this.getGrade();
        return(g,companyName,pledge,value,_v,_r,_s,signerList,addBorrow,addMortgage);
    }

    function addSignatures(uint8 v, bytes32 r, bytes32 s) public returns(bool) {
        for(uint i= 0 ;i<signers.length ;i++)
        {
            if(msg.sender == signers[i])
            {
                if( _v[i] == v && _r[i] == r && _s[i] == s)
                {
                    emit addRepeatSignaturesEvent(grade,companyName,pledge,value,v,r,s);
                    return true;
                }
                else
                {
                     emit errorRepeatSignaturesEvent(grade,companyName,pledge,value,v,r,s,msg.sender);
                     return false;
                }
            }
        }
       if(CallVerify(msg.sender))
       {
            _v.push(v);
            _r.push(r);
            _s.push(s);
            signers.push(msg.sender);
            emit addSignaturesEvent(grade,companyName,pledge,value,v,r,s);
            return true;
       }
       else
       {
           emit errorAddSignaturesEvent(grade,companyName,pledge,value,v,r,s,msg.sender);
           return false;
       }
    }
    
    function getSigners()public constant returns(address[])
    {
         uint length = CreditSignersDataABI(signersAddr).getSignersSize();
         address[] memory signerList = new address[](length);
         for(uint i= 0 ;i<length ;i++)
         {
             signerList[i] = (CreditSignersDataABI(signersAddr).getSigner(i));
         }
         return signerList;
    }

    function getPledge() public constant returns(bool){
         return pledge;
    }

    function getValue() public constant returns(int256){
         return value;
    }

    function getGrade() public constant returns(int256){
        if(addBorrow == address(0)){
             return grade;
        }
        Borrow b = Borrow(addBorrow);
        b.violate(); 
        return grade;
    }

    function getCompanyName() public constant returns(string){
         return companyName;
    }

    function setPledge(bool p) public {
        pledge = p;
    }

    function setValue(int256 v)public{
        value = v;
    }

    function setGrade(int256 grd)public{
        grade = grd;
    }

    function setBorrow(address add)public{
        addBorrow = add;
    }

    function getBorrow()public constant returns(address){
        return addBorrow;
    }

    function setMortgage(address add)public{
        addMortgage = add;
    }

    function getMortgage()public constant returns(address){
        return addMortgage;
    }
}
