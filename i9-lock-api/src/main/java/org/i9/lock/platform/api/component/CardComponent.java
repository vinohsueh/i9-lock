package org.i9.lock.platform.api.component;


import org.i9.lock.platform.model.Card;

import com.alibaba.fastjson.JSONObject;

public class CardComponent {
	    private Card card;
	    private int number;
	    
	    public CardComponent setCard(Card card){
	        this.card = card;
	        return this;
	    }
	    
	    public CardComponent setNumber(int userNumber) {
	        this.number = userNumber;
	        return this;
	    }
	    
	    public JSONObject build() {
	        JSONObject jsonObject = new JSONObject();
	        jsonObject.put("id", card.getId());
	        jsonObject.put("name", card.getName());
	        jsonObject.put("orderNumber", card.getOrderNumber());
	        jsonObject.put("userNumber", number);
	        jsonObject.put("type", card.getType());
	        return jsonObject;
	    }

}
