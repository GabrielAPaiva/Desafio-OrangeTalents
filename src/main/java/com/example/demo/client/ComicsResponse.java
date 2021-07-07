package com.example.demo.client;

import com.example.demo.model.Comic;
import com.example.demo.model.Day;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


//@Entity
public class ComicsResponse {

    private String code;
    private String status;
    private Dados data;

    public Comic toComic(){
        var comic = new Comic();
        var results = data.getResults();

        comic.setId(results.get(0).getId());
        comic.setDescription(results.get(0).getDescription());
        comic.setTitle(results.get(0).getTitle());
        comic.setIsbn(results.get(0).getIsbn());
        comic.setDia(getDia(results.get(0).getIsbn()));
        comic.setDesconto(avaliaDesconto(results));


        if(!results.get(0).getCreators().getItems().isEmpty()){
            comic.setCreator(results.get(0).getCreators().getItems().get(0).getName());
        }

        if(avaliaDesconto(results)) {
            BigDecimal preco =  results.get(0).getPrices().get(0).getPrice();
            BigDecimal desconto = preco.multiply( new BigDecimal("0.1"));
            BigDecimal valorFinal = preco.subtract(desconto).setScale(2,BigDecimal.ROUND_HALF_UP);
            comic.setPrice(valorFinal);
        }else{
            comic.setPrice(results.get(0).getPrices().get(0).getPrice());
        }

        return  comic;

    }

    public Day getDia(String isbn){

        String digito = String.valueOf(isbn.charAt(isbn.length() - 1));

        switch(digito){
            case "0" :
                return Day.SEGUNDA;
            case "1" :
                return Day.SEGUNDA;
            case "2":
                return Day.TERÇA;
            case "3":
                return Day.TERÇA;
            case "4":
                return Day.QUARTA;
            case "5":
                return Day.QUARTA;
            case "6":
                return Day.QUINTA;
            case "7":
                return Day.QUINTA;
            case "8":
                return Day.SEXTA;
            case "9":
                return Day.SEXTA;
            default: return  null;
        }
    }

    public Boolean avaliaDesconto(List<Comics> results){

        var data = LocalDate.now();
        var diaSistema = data.getDayOfWeek().getValue();
        var diaDesconto = getDia(results.get(0).getIsbn());

        if(diaDesconto.ordinal() == diaSistema) return  true;
        return  false;

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Dados getData() {
        return data;
    }

    public void setData(Dados data) {
        this.data = data;
    }
}


