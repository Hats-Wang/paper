pragma solidity ^0.4.4;

import "./Credit.sol";

contract Mortgage{
    bool success;
    uint256 time;

    function Mortgage(bool b){
        success = b;
        time = now;
    }
    function mortgage(address add, int256 num) public{
        Credit cre = Credit(add);
        int256 value = cre.getValue();
        if((value >= num) && (!cre.getPledge())) {
            cre.setPledge(true);
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
