package org.bcos.credit.web3j;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.web3j.abi.FunctionEncoder;
import org.fisco.bcos.web3j.abi.FunctionReturnDecoder;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Bool;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.crypto.EncryptType;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple1;
import org.fisco.bcos.web3j.tx.Contract;
import org.fisco.bcos.web3j.tx.TransactionManager;
import org.fisco.bcos.web3j.tx.gas.ContractGasProvider;
import org.fisco.bcos.web3j.tx.txdecode.TransactionDecoder;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.fisco.bcos.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version none.
 */
@SuppressWarnings("unchecked")
public class Borrow extends Contract {
    public static final String[] BINARY_ARRAY = {"608060405234801561001057600080fd5b50604051606080610a868339810180604052810190808051906020019092919080519060200190929190805190602001909291905050506000836000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508260018190555081600281905550603c6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166346998f406040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561011e57600080fd5b505af1158015610132573d6000803e3d6000fd5b505050506040513d602081101561014857600080fd5b8101908080519060200190929190505050121561016457610386565b838261016e61038f565b808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050604051809103906000f0801580156101c7573d6000803e3d6000fd5b5090508073ffffffffffffffffffffffffffffffffffffffff1663a79c60ac6040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561022e57600080fd5b505af1158015610242573d6000803e3d6000fd5b505050506040513d602081101561025857600080fd5b810190808051906020019092919050505015610369576001600360006101000a81548160ff021916908315150217905550426004819055506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166340e9cd2e306040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050600060405180830381600087803b15801561034c57600080fd5b505af1158015610360573d6000803e3d6000fd5b50505050610385565b6000600360006101000a81548160ff0219169083151502179055505b5b5050505061039f565b6040516103f38061069383390190565b6102e5806103ae6000396000f300608060405260043610610057576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680633927f6af1461005c578063e8e621781461008b578063f9633930146100a2575b600080fd5b34801561006857600080fd5b506100896004803603810190808035151590602001909291905050506100d1565b005b34801561009757600080fd5b506100a06100ee565b005b3480156100ae57600080fd5b506100b76102a2565b604051808215151515815260200191505060405180910390f35b80600360006101000a81548160ff02191690831515021790555050565b6000600360009054906101000a900460ff16801561011157506001546004544203115b1561029f576000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166346998f406040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561019b57600080fd5b505af11580156101af573d6000803e3d6000fd5b505050506040513d60208110156101c557600080fd5b810190808051906020019092919050505090506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16631190ce73600583036040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180828152602001915050600060405180830381600087803b15801561026b57600080fd5b505af115801561027f573d6000803e3d6000fd5b505050506000600360006101000a81548160ff0219169083151502179055505b50565b6000600360009054906101000a900460ff169050905600a165627a7a72305820d3c2e6fd6ade675c3dde7db2fca954c3a475ed5d263d38f4b75a5ebb1c8be8f40029608060405234801561001057600080fd5b506040516040806103f3833981018060405281019080805190602001909291908051906020019092919050505060008060008060006101000a81548160ff021916908315150217905550426001819055508391508173ffffffffffffffffffffffffffffffffffffffff1663209652556040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b1580156100c857600080fd5b505af11580156100dc573d6000803e3d6000fd5b505050506040513d60208110156100f257600080fd5b810190808051906020019092919050505090508281121580156101b157508173ffffffffffffffffffffffffffffffffffffffff1663c8f5acb66040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561017457600080fd5b505af1158015610188573d6000803e3d6000fd5b505050506040513d602081101561019e57600080fd5b8101908080519060200190929190505050155b15610314578173ffffffffffffffffffffffffffffffffffffffff1663a426cefc60016040518263ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018082151515158152602001915050600060405180830381600087803b15801561022a57600080fd5b505af115801561023e573d6000803e3d6000fd5b505050508173ffffffffffffffffffffffffffffffffffffffff166312e713b8306040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050600060405180830381600087803b1580156102dd57600080fd5b505af11580156102f1573d6000803e3d6000fd5b5050505060016000806101000a81548160ff02191690831515021790555061032f565b60008060006101000a81548160ff0219169083151502179055505b5050505060b2806103416000396000f300608060405260043610603f576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063a79c60ac146044575b600080fd5b348015604f57600080fd5b5060566070565b604051808215151515815260200191505060405180910390f35b60008060009054906101000a900460ff169050905600a165627a7a72305820f3bf310f3afd89b8ab015945b955f374a9b46afd0db81bd7497c1f01675bb9ae0029"};

    public static final String BINARY = String.join("", BINARY_ARRAY);

    public static final String[] ABI_ARRAY = {"[{\"constant\":false,\"inputs\":[{\"name\":\"b\",\"type\":\"bool\"}],\"name\":\"setFlag\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[],\"name\":\"violate\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getFlag\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[{\"name\":\"add\",\"type\":\"address\"},{\"name\":\"time\",\"type\":\"uint256\"},{\"name\":\"num\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"}]"};

    public static final String ABI = String.join("", ABI_ARRAY);

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String[] SM_BINARY_ARRAY = {"608060405234801561001057600080fd5b50604051606080610a868339810180604052810190808051906020019092919080519060200190929190805190602001909291905050506000836000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508260018190555081600281905550603c6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663322a941f6040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561011e57600080fd5b505af1158015610132573d6000803e3d6000fd5b505050506040513d602081101561014857600080fd5b8101908080519060200190929190505050121561016457610386565b838261016e61038f565b808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050604051809103906000f0801580156101c7573d6000803e3d6000fd5b5090508073ffffffffffffffffffffffffffffffffffffffff16636351e9406040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561022e57600080fd5b505af1158015610242573d6000803e3d6000fd5b505050506040513d602081101561025857600080fd5b810190808051906020019092919050505015610369576001600360006101000a81548160ff021916908315150217905550426004819055506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166366108bde306040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050600060405180830381600087803b15801561034c57600080fd5b505af1158015610360573d6000803e3d6000fd5b50505050610385565b6000600360006101000a81548160ff0219169083151502179055505b5b5050505061039f565b6040516103f38061069383390190565b6102e5806103ae6000396000f300608060405260043610610057576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806330847aae1461005c578063327cfb821461007357806337742e27146100a2575b600080fd5b34801561006857600080fd5b506100716100d1565b005b34801561007f57600080fd5b506100a0600480360381019080803515159060200190929190505050610285565b005b3480156100ae57600080fd5b506100b76102a2565b604051808215151515815260200191505060405180910390f35b6000600360009054906101000a900460ff1680156100f457506001546004544203115b15610282576000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663322a941f6040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561017e57600080fd5b505af1158015610192573d6000803e3d6000fd5b505050506040513d60208110156101a857600080fd5b810190808051906020019092919050505090506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663b4694425600583036040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180828152602001915050600060405180830381600087803b15801561024e57600080fd5b505af1158015610262573d6000803e3d6000fd5b505050506000600360006101000a81548160ff0219169083151502179055505b50565b80600360006101000a81548160ff02191690831515021790555050565b6000600360009054906101000a900460ff169050905600a165627a7a72305820f7ebe24c42ee8b4da4daa191713f690ffc07f2dced6d4da3bcb4f6d20e1e7a770029608060405234801561001057600080fd5b506040516040806103f3833981018060405281019080805190602001909291908051906020019092919050505060008060008060006101000a81548160ff021916908315150217905550426001819055508391508173ffffffffffffffffffffffffffffffffffffffff16639f00d7356040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b1580156100c857600080fd5b505af11580156100dc573d6000803e3d6000fd5b505050506040513d60208110156100f257600080fd5b810190808051906020019092919050505090508281121580156101b157508173ffffffffffffffffffffffffffffffffffffffff166334f196316040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561017457600080fd5b505af1158015610188573d6000803e3d6000fd5b505050506040513d602081101561019e57600080fd5b8101908080519060200190929190505050155b15610314578173ffffffffffffffffffffffffffffffffffffffff16631864e58860016040518263ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018082151515158152602001915050600060405180830381600087803b15801561022a57600080fd5b505af115801561023e573d6000803e3d6000fd5b505050508173ffffffffffffffffffffffffffffffffffffffff166344dacbe1306040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050600060405180830381600087803b1580156102dd57600080fd5b505af11580156102f1573d6000803e3d6000fd5b5050505060016000806101000a81548160ff02191690831515021790555061032f565b60008060006101000a81548160ff0219169083151502179055505b5050505060b2806103416000396000f300608060405260043610603f576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680636351e940146044575b600080fd5b348015604f57600080fd5b5060566070565b604051808215151515815260200191505060405180910390f35b60008060009054906101000a900460ff169050905600a165627a7a723058207a07aa4c918712334aa21692d1389fa55d6f35ad8000861302da2381c0b5d0c90029"};

    public static final String SM_BINARY = String.join("", SM_BINARY_ARRAY);

    public static final String FUNC_SETFLAG = "setFlag";

    public static final String FUNC_VIOLATE = "violate";

    public static final String FUNC_GETFLAG = "getFlag";

    @Deprecated
    protected Borrow(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(getBinary(), contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Borrow(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(getBinary(), contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Borrow(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(getBinary(), contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Borrow(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(getBinary(), contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static String getBinary() {
        return (EncryptType.encryptType == EncryptType.ECDSA_TYPE ? BINARY : SM_BINARY);
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
    }

    public RemoteCall<TransactionReceipt> setFlag(Boolean b) {
        final Function function = new Function(
                FUNC_SETFLAG, 
                Arrays.<Type>asList(new Bool(b)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setFlag(Boolean b, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETFLAG, 
                Arrays.<Type>asList(new Bool(b)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setFlagSeq(Boolean b) {
        final Function function = new Function(
                FUNC_SETFLAG, 
                Arrays.<Type>asList(new Bool(b)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<Boolean> getSetFlagInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETFLAG, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<Boolean>(

                (Boolean) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> violate() {
        final Function function = new Function(
                FUNC_VIOLATE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void violate(TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_VIOLATE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String violateSeq() {
        final Function function = new Function(
                FUNC_VIOLATE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<Boolean> getFlag() {
        final Function function = new Function(FUNC_GETFLAG, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    @Deprecated
    public static Borrow load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Borrow(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Borrow load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Borrow(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Borrow load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Borrow(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Borrow load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Borrow(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Borrow> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String add, BigInteger time, BigInteger num) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(add), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(time), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(num)));
        return deployRemoteCall(Borrow.class, web3j, credentials, contractGasProvider, getBinary(), encodedConstructor);
    }

    public static RemoteCall<Borrow> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String add, BigInteger time, BigInteger num) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(add), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(time), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(num)));
        return deployRemoteCall(Borrow.class, web3j, transactionManager, contractGasProvider, getBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Borrow> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String add, BigInteger time, BigInteger num) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(add), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(time), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(num)));
        return deployRemoteCall(Borrow.class, web3j, credentials, gasPrice, gasLimit, getBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Borrow> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String add, BigInteger time, BigInteger num) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(add), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(time), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(num)));
        return deployRemoteCall(Borrow.class, web3j, transactionManager, gasPrice, gasLimit, getBinary(), encodedConstructor);
    }
}
