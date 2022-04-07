pragma solidity ^0.4.4;

import "./Credit.sol";

contract Borrow{
    Credit cre;
    uint256 month;
    int256 money;
    bool flag;
    uint256 t = now;

    function Borrow(address add, uint256 time, int256 num) public{
        cre = Credit(add);
        month = time;
        money = num;
        flag = true;
        cre.setBorrow(address(this));
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
