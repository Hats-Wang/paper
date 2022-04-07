package org.bcos.credit.web3j;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.web3j.abi.FunctionEncoder;
import org.fisco.bcos.web3j.abi.FunctionReturnDecoder;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Address;
import org.fisco.bcos.web3j.abi.datatypes.Bool;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int256;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.crypto.EncryptType;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple2;
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
public class Mortgage extends Contract {
    public static final String[] BINARY_ARRAY = {"608060405234801561001057600080fd5b5060405160208061039683398101806040528101908080519060200190929190505050806000806101000a81548160ff0219169083151502179055504260018190555050610333806100636000396000f30060806040526004361061004c576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063a79c60ac14610051578063c4a4647e14610080575b600080fd5b34801561005d57600080fd5b506100666100cd565b604051808215151515815260200191505060405180910390f35b34801561008c57600080fd5b506100cb600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291905050506100e3565b005b60008060009054906101000a900460ff16905090565b6000808391508173ffffffffffffffffffffffffffffffffffffffff1663209652556040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561014d57600080fd5b505af1158015610161573d6000803e3d6000fd5b505050506040513d602081101561017757600080fd5b8101908080519060200190929190505050905082811215801561023657508173ffffffffffffffffffffffffffffffffffffffff1663c8f5acb66040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b1580156101f957600080fd5b505af115801561020d573d6000803e3d6000fd5b505050506040513d602081101561022357600080fd5b8101908080519060200190929190505050155b156102e6578173ffffffffffffffffffffffffffffffffffffffff1663a426cefc60016040518263ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018082151515158152602001915050600060405180830381600087803b1580156102af57600080fd5b505af11580156102c3573d6000803e3d6000fd5b5050505060016000806101000a81548160ff021916908315150217905550610301565b60008060006101000a81548160ff0219169083151502179055505b505050505600a165627a7a72305820efcecc5460038443f47dcc891986ec0aaa81df3b2800fd32ef4b7e3f786079ed0029"};

    public static final String BINARY = String.join("", BINARY_ARRAY);

    public static final String[] ABI_ARRAY = {"[{\"constant\":true,\"inputs\":[],\"name\":\"getSuc\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"add\",\"type\":\"address\"},{\"name\":\"num\",\"type\":\"int256\"}],\"name\":\"mortgage\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[{\"name\":\"b\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"}]"};

    public static final String ABI = String.join("", ABI_ARRAY);

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String[] SM_BINARY_ARRAY = {"608060405234801561001057600080fd5b5060405160208061039683398101806040528101908080519060200190929190505050806000806101000a81548160ff0219169083151502179055504260018190555050610333806100636000396000f30060806040526004361061004c576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680636351e94014610051578063ec70674314610080575b600080fd5b34801561005d57600080fd5b506100666100cd565b604051808215151515815260200191505060405180910390f35b34801561008c57600080fd5b506100cb600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291905050506100e3565b005b60008060009054906101000a900460ff16905090565b6000808391508173ffffffffffffffffffffffffffffffffffffffff16639f00d7356040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561014d57600080fd5b505af1158015610161573d6000803e3d6000fd5b505050506040513d602081101561017757600080fd5b8101908080519060200190929190505050905082811215801561023657508173ffffffffffffffffffffffffffffffffffffffff166334f196316040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b1580156101f957600080fd5b505af115801561020d573d6000803e3d6000fd5b505050506040513d602081101561022357600080fd5b8101908080519060200190929190505050155b156102e6578173ffffffffffffffffffffffffffffffffffffffff16631864e58860016040518263ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018082151515158152602001915050600060405180830381600087803b1580156102af57600080fd5b505af11580156102c3573d6000803e3d6000fd5b5050505060016000806101000a81548160ff021916908315150217905550610301565b60008060006101000a81548160ff0219169083151502179055505b505050505600a165627a7a72305820b162eb5c5a50d414d66377fd55cfa3b421181a3f32fba7705d3f2b4d692d652f0029"};

    public static final String SM_BINARY = String.join("", SM_BINARY_ARRAY);

    public static final String FUNC_GETSUC = "getSuc";

    public static final String FUNC_MORTGAGE = "mortgage";

    @Deprecated
    protected Mortgage(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(getBinary(), contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Mortgage(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(getBinary(), contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Mortgage(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(getBinary(), contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Mortgage(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(getBinary(), contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static String getBinary() {
        return (EncryptType.encryptType == EncryptType.ECDSA_TYPE ? BINARY : SM_BINARY);
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
    }

    public RemoteCall<Boolean> getSuc() {
        final Function function = new Function(FUNC_GETSUC, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> mortgage(String add, BigInteger num) {
        final Function function = new Function(
                FUNC_MORTGAGE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(add), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(num)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void mortgage(String add, BigInteger num, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_MORTGAGE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(add), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(num)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String mortgageSeq(String add, BigInteger num) {
        final Function function = new Function(
                FUNC_MORTGAGE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(add), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(num)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, BigInteger> getMortgageInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_MORTGAGE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Int256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<String, BigInteger>(

                (String) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue()
                );
    }

    @Deprecated
    public static Mortgage load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Mortgage(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Mortgage load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Mortgage(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Mortgage load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Mortgage(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Mortgage load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Mortgage(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Mortgage> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, Boolean b) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Bool(b)));
        return deployRemoteCall(Mortgage.class, web3j, credentials, contractGasProvider, getBinary(), encodedConstructor);
    }

    public static RemoteCall<Mortgage> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, Boolean b) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Bool(b)));
        return deployRemoteCall(Mortgage.class, web3j, transactionManager, contractGasProvider, getBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Mortgage> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, Boolean b) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Bool(b)));
        return deployRemoteCall(Mortgage.class, web3j, credentials, gasPrice, gasLimit, getBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Mortgage> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, Boolean b) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Bool(b)));
        return deployRemoteCall(Mortgage.class, web3j, transactionManager, gasPrice, gasLimit, getBinary(), encodedConstructor);
    }
}
