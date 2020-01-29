package com.mycompany.apap;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BankRepository 
{
    private List<Bank> transfers;
    
    public BankRepository()
    {
        transfers = new ArrayList<>();
        transfers.add(new Bank(1L, "Pekao - sesje wychodzace: 8.30 12.30 15:00, sesje przychodzace: 11.00 15:00 17:30", "Pekao"));
        transfers.add(new Bank(2L, "ING - sesje wychodzace: 8:10 11:30 14:30, sesje przychodzace: 11:00 15:00 17:30", "ING"));
        transfers.add(new Bank(3L, "Citi - sesje wychodzace: 8:00 12:15 15:30, sesje przychodzace: 11:30 15:30 17:30", "Citi"));
        transfers.add(new Bank(4L, "Alior - sesje wychodzace: 9:30 13:30 16:00, sesje przychodzace: 11:00 - 12:00 15:00 - 15:30 17:00 - 17:30", "Alior"));
        transfers.add(new Bank(5L, "BNP Paribas - sesje wychodzace: 8:00 11:45 14:15, sesje przychodzace: 11:00 do 12:00 14:30 do 15:00 17:00", "BNP Paribas"));
        transfers.add(new Bank(6L, "Millennium - sesje wychodzace: 8.10 12.10 14:30, sesje przychodzace: 12.00 15:30 17:15", "Millenium"));
        transfers.add(new Bank(7L, "PKO BP - sesje wychodzace: 8:00 11:45 14:30, sesje przychodzace: 11:30 15:10 17:30", "PKO BP"));
    }
    
    public Optional<Bank> findById(Long id)
    {
        return transfers.stream().
                filter(b -> b.getId()
                        .equals(id)).findFirst();

    }
}
