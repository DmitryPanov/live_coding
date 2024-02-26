package coding.streams.live.streams.transaction.service;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
        List<TransactionService.TransactionData> transactionDataList = new LinkedList<>();
        transactionDataList.add(new TransactionService.TransactionData(TransactionService.Type.REFUND, "EUR", 2000L));
        transactionDataList.add(new TransactionService.TransactionData(TransactionService.Type.REFUND, "USD", 15L));
        transactionDataList.add(new TransactionService.TransactionData(TransactionService.Type.REFUND, "RUB", 200L));
        transactionDataList.add(new TransactionService.TransactionData(TransactionService.Type.PAYMENT, "RUB", 1250L));
        transactionDataList.add(new TransactionService.TransactionData(TransactionService.Type.REFUND, "USD", 35L));
        transactionDataList.add(new TransactionService.TransactionData(TransactionService.Type.PAYMENT, "USD", 55L));
        transactionDataList.add(new TransactionService.TransactionData(TransactionService.Type.REFUND, "RUB", 100L));
        //["EUR" -> 2000.0, "RUB" -> 150.0, "USD" -> 25.0]
        System.out.println(transactionDataList.stream()
                .filter(transactionData -> transactionData.type.equals(TransactionService.Type.REFUND))
                .collect(Collectors.groupingBy(e -> e.currency, () -> new TreeMap<String, Double>(), Collectors.averagingLong(value -> value.amount)))
        );

        System.out.println(transactionDataList.stream().
                filter(transactionData -> transactionData.type.equals(TransactionService.Type.REFUND))
                .collect(Collectors.groupingBy(TransactionService.TransactionData::getCurrency, //groupingBy работает как GROUP BY in SQL. Используется для группировки объектов
                        Collectors.averagingDouble(TransactionService.TransactionData::getAmount))));

    }
}
