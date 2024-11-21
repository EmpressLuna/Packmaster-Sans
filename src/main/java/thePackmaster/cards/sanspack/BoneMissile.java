package thePackmaster.cards.sanspack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class BoneMissile extends AbstractSansCard {

    public final static String ID = makeID("BoneMissile");

    public BoneMissile() {
        super(ID, 1, AbstractCard.CardType.ATTACK, AbstractCard.CardRarity.COMMON, AbstractCard.CardTarget.ENEMY);
        baseDamage = 1;
        magicNumber = 6;
        baseMagicNumber = magicNumber;
        secondMagic = 2;
        baseSecondMagic = secondMagic;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        for (int i = 0; i < magicNumber; i++) {
            dmg(m, AbstractGameAction.AttackEffect.NONE);
        }
    }

    public void upp() {
        upgradeMagicNumber(2);
    }

    public void applyPowers() {
        AbstractPower strength = AbstractDungeon.player.getPower("Strength");
        int value = 0;

        if (strength != null) {
            value = strength.amount;
            strength.amount = 0;
        }

        super.applyPowers();
        if (strength != null) {
            strength.amount = value;
        }

    }

    public void calculateCardDamage(AbstractMonster mo) {
        AbstractPower strength = AbstractDungeon.player.getPower("Strength");
        int value = 0;

        if (strength != null) {
            value = strength.amount;
            strength.amount = 0;
        }

        super.calculateCardDamage(mo);
        if (strength != null) {
            strength.amount = value;
        }

    }

}
