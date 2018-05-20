package agh.cs.lab.vending_machine;

import java.util.ArrayList;
import java.util.List;

public class CoinSlot {
    List<Coin> coinsList;

    double currentValue;

    final int coinsLimit;

    boolean filled;

    public CoinSlot(int coinsLimit) {
        this.coinsLimit = coinsLimit;
        this.coinsList = new ArrayList<Coin>(coinsLimit);
        this.currentValue = 0;
        filled = coinsLimit > 0;
    }

    boolean insertCoin(Coin coin) {
        if (filled) {
            return false;
        } else {
            coinsList.add(coin);
            currentValue += coin.value;
            filled = coinsList.size() == coinsLimit;
            return true;
        }
    }

    boolean returnCoins() {
        if (coinsList.isEmpty()) {
            return false;
        } else {
            empty();
            return true;
        }
    }

    void empty() {
        coinsList.clear();
        currentValue = 0;
    }
}
