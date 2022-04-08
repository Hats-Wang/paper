pragma solidity ^0.4.4;

import "./Credit.sol";
import"./Mortgage.sol";

contract Borrow{
    Credit cre;
    uint256 month;
    int256 money;
    bool flag;
    uint256 t;

    function Borrow(address add, uint256 time, int256 num) public{
        cre = Credit(add);
        month = time;
        money = num;
        if(cre.getGrade() < 60) return ;
        Mortgage m = new Mortgage(add, num);
        if(m.getSuc()){
            flag = true;
            t = now;
            cre.setBorrow(address(this));
        }else{
            flag = false;
        }
    }


    function violate() public {
        if(flag && ((now - t) > month)){
            int256 grd = cre.getGrade();
            cre.setGrade(grd - 5);
            flag = false;
        }
    }

    function getFlag() public constant returns (bool){
        return flag;
    }

    function setFlag(bool b) public{
        flag = b;
    }
}
