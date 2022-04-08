pragma solidity ^0.4.4;

import "./Credit.sol";

contract Mortgage{
    bool success;
    uint256 time;

    function Mortgage(address add, int256 num) public {
        success = false;
        time = now;//返回值为毫秒
        Credit cre = Credit(add);
        int256 value = cre.getValue();
        if((value >= num) && (!cre.getPledge())) {
            cre.setPledge(true);
            cre.setMortgage(address(this));
            success = true;
        }
        else{
            success = false;
        }
    }

    function getSuc()public constant returns(bool){
        return success;
    }
}
