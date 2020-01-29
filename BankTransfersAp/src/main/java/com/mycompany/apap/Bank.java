package com.mycompany.apap;

public class Bank    // a'la baza danych - języki
{
    private Long id;
    private String welcomeMsg;
    private String code;

    public Bank(Long id, String welcomeMsg, String code) 
    {
        this.id = id;
        this.welcomeMsg = welcomeMsg;
        this.code = code;
    }
    
    public Long getId() 
    {
        return id;
    }

    public String getWelcomeMsg() 
    {
        return welcomeMsg;
    }

    public void setWelcomeMsg(String welcomeMsg) 
    {
        this.welcomeMsg = welcomeMsg;
    }

    public String getCode() 
    {
        return code;
    }

    public void setCode(String code) 
    {
        this.code = code;
    }
    
}
// Plain Old Java Object (POJO) – termin używany przez 
// zwolenników idei mówiącej, że im prostszy design tym lepiej. 
// Używa się go dla określenia obiektów, będących zwyczajnymi obiektami 
// Java, nie zaś obiektami specjalnymi, w szczególności Enterprise 
// JavaBeans (zwłaszcza w implementacji wcześniejszej niż EJB3).