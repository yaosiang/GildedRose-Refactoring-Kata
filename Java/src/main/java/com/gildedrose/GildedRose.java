package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }

        if (item.name.equals("Aged Brie")) {
            upgradeAgedBrie(item);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            upgradeBackstagePasses(item);
        } else {
            upgradeNormal(item);
        }
    }

    public void upgradeNormal(Item item) {
        item.sellIn = item.sellIn - 1;
        decreaseQuality(item);
        if (item.sellIn < 0) {
            decreaseQuality(item);
        }
    }

    public void upgradeBackstagePasses(Item item) {
        item.sellIn = item.sellIn - 1;
        increaseQuality(item);
        if (item.sellIn < 10) {
            increaseQuality(item);
        }
        if (item.sellIn < 5) {
            increaseQuality(item);
        }
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    public void upgradeAgedBrie(Item item) {
        item.sellIn = item.sellIn - 1;
        increaseQuality(item);
        if (item.sellIn < 0) {
            increaseQuality(item);
        }
    }

    public void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    public void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}