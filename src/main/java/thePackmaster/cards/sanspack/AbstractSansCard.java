package thePackmaster.cards.sanspack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.ThePackmaster;
import thePackmaster.cards.AbstractPackmasterCard;

import static thePackmaster.util.Wiz.atb;

public abstract class AbstractSansCard extends AbstractPackmasterCard {

    protected boolean isBony = false;

    public AbstractSansCard(String cardID, int cost, CardType type, CardRarity rarity, CardTarget target, CardColor color) {
        super(cardID, cost, type, rarity, target, color, "sans");

    }

    public AbstractSansCard(String cardID, int cost, CardType type, CardRarity rarity, CardTarget target) {
        this (cardID, cost, type, rarity, target, ThePackmaster.Enums.PACKMASTER_RAINBOW);
    }

    @Override
    public void applyPowers() {
        if (isBony) {
            super.applyPowers();
            damage = 1;
            baseDamage = 1;

        } else {
            super.applyPowers();
        }
    }

    @Override
    public void calculateCardDamage(AbstractMonster mo) {
        if (isBony) {
            super.calculateCardDamage(mo);
            damage = 1;
            baseDamage = 1;

        } else {
            super.calculateCardDamage(mo);
        }
    }

    protected void dmgf(AbstractMonster m, AbstractGameAction.AttackEffect fx) {
        atb(new DamageAction(m, new DamageInfo(AbstractDungeon.player, damage, damageTypeForTurn), fx, true));
    }
}
