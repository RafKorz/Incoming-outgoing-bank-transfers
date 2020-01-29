package com.mycompany.apap;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApApService 
{
    public static final String FALLBACK_NAME = "World";
    public static final Bank FALLBACK_BANK = new Bank(1L, "Hello", "Pekao");
    private final Logger logger = LoggerFactory.getLogger(ApApService.class);
    
    private BankRepository repository;
    
    public ApApService()
    {
        this(new BankRepository());
    }
    
    public ApApService(BankRepository repository)
    {
        this.repository = repository;
    }
//    
//    public String prepareGreeting(String name)
//    {
//        return prepareGreeting(name, null);
//    }    
    
    public String prepareGreeting(String name, String bank)
    {
        Long bankId;
        try
        {
            bankId = Optional.ofNullable(bank).map(Long::valueOf).orElse(FALLBACK_BANK.getId());
        }
        catch(NumberFormatException e)
        {
            logger.warn("Non-numeric bank id used: " + bank);
            bankId = FALLBACK_BANK.getId();
        }
        String welcomeMsg = repository.findById(bankId).orElse(FALLBACK_BANK).getWelcomeMsg();
        String nameToWelcome = Optional.ofNullable(name).orElse(FALLBACK_NAME);
        return welcomeMsg + " " + nameToWelcome + "!";
    }
}
