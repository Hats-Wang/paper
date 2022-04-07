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
    public static final String[] BINARY_ARRAY = {"60806040524260045534801561001457600080fd5b5060405160608061047f833981018060405281019080805190602001909291908051906020019092919080519060200190929190505050826000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555081600181905550806002819055506001600360006101000a81548160ff0219169083151502179055506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166340e9cd2e306040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050600060405180830381600087803b15801561017057600080fd5b505af1158015610184573d6000803e3d6000fd5b505050505050506102e58061019a6000396000f300608060405260043610610057576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680633927f6af1461005c578063e8e621781461008b578063f9633930146100a2575b600080fd5b34801561006857600080fd5b506100896004803603810190808035151590602001909291905050506100d1565b005b34801561009757600080fd5b506100a06100ee565b005b3480156100ae57600080fd5b506100b76102a2565b604051808215151515815260200191505060405180910390f35b80600360006101000a81548160ff02191690831515021790555050565b6000600360009054906101000a900460ff16801561011157506001546004544203115b1561029f576000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166346998f406040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561019b57600080fd5b505af11580156101af573d6000803e3d6000fd5b505050506040513d60208110156101c557600080fd5b810190808051906020019092919050505090506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16631190ce73600583036040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180828152602001915050600060405180830381600087803b15801561026b57600080fd5b505af115801561027f573d6000803e3d6000fd5b505050506000600360006101000a81548160ff0219169083151502179055505b50565b6000600360009054906101000a900460ff169050905600a165627a7a723058202a11c525a8bf24810b263f340d97f91dc2929504335e3ef43d23b78dda2714660029"};

    public static final String BINARY = String.join("", BINARY_ARRAY);

    public static final String[] ABI_ARRAY = {"[{\"constant\":false,\"inputs\":[{\"name\":\"b\",\"type\":\"bool\"}],\"name\":\"setFlag\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[],\"name\":\"violate\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getFlag\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[{\"name\":\"add\",\"type\":\"address\"},{\"name\":\"time\",\"type\":\"uint256\"},{\"name\":\"num\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"}]"};

    public static final String ABI = String.join("", ABI_ARRAY);

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String[] SM_BINARY_ARRAY = {"60806040524260045534801561001457600080fd5b5060405160608061047f833981018060405281019080805190602001909291908051906020019092919080519060200190929190505050826000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555081600181905550806002819055506001600360006101000a81548160ff0219169083151502179055506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166366108bde306040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050600060405180830381600087803b15801561017057600080fd5b505af1158015610184573d6000803e3d6000fd5b505050505050506102e58061019a6000396000f300608060405260043610610057576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806330847aae1461005c578063327cfb821461007357806337742e27146100a2575b600080fd5b34801561006857600080fd5b506100716100d1565b005b34801561007f57600080fd5b506100a0600480360381019080803515159060200190929190505050610285565b005b3480156100ae57600080fd5b506100b76102a2565b604051808215151515815260200191505060405180910390f35b6000600360009054906101000a900460ff1680156100f457506001546004544203115b15610282576000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663322a941f6040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561017e57600080fd5b505af1158015610192573d6000803e3d6000fd5b505050506040513d60208110156101a857600080fd5b810190808051906020019092919050505090506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663b4694425600583036040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180828152602001915050600060405180830381600087803b15801561024e57600080fd5b505af1158015610262573d6000803e3d6000fd5b505050506000600360006101000a81548160ff0219169083151502179055505b50565b80600360006101000a81548160ff02191690831515021790555050565b6000600360009054906101000a900460ff169050905600a165627a7a72305820754ad7270c595f38da7273d49fb5ae5c83d275ba6940e3acdf26e7ab234b99aa0029"};

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
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Bool(b)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setFlag(Boolean b, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETFLAG, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Bool(b)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setFlagSeq(Boolean b) {
        final Function function = new Function(
                FUNC_SETFLAG, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Bool(b)), 
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
