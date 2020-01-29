import com.mycompany.apap.ApApService;
import com.mycompany.apap.Bank;
import com.mycompany.apap.BankRepository;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ApApServiceTest 
{
    private final static String WELCOME = "Hello";
    private final static String FALLBACK_ID_WELCOME = "Hola hola!";
    
    @Test
    public Optional<Bank> test_prepareGreeting_nullName_returnsGreetingWithFallbackValue() throws Exception
    {
        ///given
        BankRepository mockRepository = alwaysReturningBankRepository();
        ApApService SUT = new ApApService(mockRepository);
        //when
        String result = SUT.prepareGreeting(null, "-1");
                
        //then
        assertEquals(WELCOME + ApApService.FALLBACK_NAME + "!", result);
        return null;
    }
    
    @Test
    public void test_prepareGreeting_name_returnsGreetingWithName() throws Exception
    {
        //given
        ApApService SUT = new ApApService();
        String name = "test";
        
        //when
        String result = SUT.prepareGreeting(name, "-1"); 
                
        //then
        assertEquals(WELCOME + name + "!", result);
    }
    
    @Test
    public void test_prepareGreeting_nullBank_returnsGreetingWithFallbackIdBank() throws Exception
    {
        //given
        BankRepository mockRepository = falllbackBankIdRepository();
        ApApService SUT = new ApApService(mockRepository);
        
        //when
        String result = SUT.prepareGreeting(null, null); 
                
        //then
        assertEquals(FALLBACK_ID_WELCOME + ApApService.FALLBACK_NAME + "!", result);
    }

//    @Test
//    public void test_prepareGreeting_nonExistingBank_returnsGreetingWithFallbackIdBank() throws Exception
//    {
//        //given
//        BankRepository mockRepository = new BankRepository()
//        {
//            @Override
//            public Optional<Bank> findById(Bank id) 
//            {
//                return Optional.empty(); 
//            }                    
//        };
//        ApApService SUT = new ApApService(mockRepository);
//        
//        //when
//        String result = SUT.prepareGreeting(null, null); 
//                
//        //then
//        assertEquals(ApApService.FALLBACK_BANK.getWelcomeMsg() + ApApService.FALLBACK_NAME + "!", result);
//    }
    
    @Test
    public void test_prepareGreeting_textBank_returnsGreetingWithFallbackIdBank() throws Exception
    {
        //given
        BankRepository mockRepository = falllbackBankIdRepository();
        ApApService SUT = new ApApService(mockRepository);
        
        //when
        String result = SUT.prepareGreeting(null, "abc"); 
                
        //then
        assertEquals(FALLBACK_ID_WELCOME + ApApService.FALLBACK_NAME + "!", result);
    }
    
    private BankRepository falllbackBankIdRepository()
    {
            return new BankRepository()
        {
            @Override
            public Optional<Bank> findById(Long id) 
            {
                if(id.equals(ApApService.FALLBACK_BANK.getId()))
                {
                    return Optional.of(new Bank(null, FALLBACK_ID_WELCOME, null));
                }
                return Optional.empty();
            }            
        };
    }
    private BankRepository alwaysReturningBankRepository() 
    {
        return new BankRepository()
        {
            @Override
            public Optional<Bank> findById(Long id) 
            {
                return super.findById(id); 
            }                    
        };
    }
}
// SUT - system under test
