package thePackmaster.cards.sanspack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import thePackmaster.powers.sanspack.KarmaPower;
import thePackmaster.util.Wiz;

import java.util.Iterator;

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
        isBony = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        for (int i = 0; i < magicNumber; i++) {
            dmgf(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
        }

        if (!m.isDeadOrEscaped() && !(m.getIntentBaseDmg() >= 0)) {
            Wiz.applyToEnemy(m, new KarmaPower(m, p, 2));
        }

    }

    public void upp() {
        upgradeMagicNumber(3);
    }

    public void triggerOnGlowCheck() {
        this.glowColor = AbstractCard.BLUE_BORDER_GLOW_COLOR.cpy();
        Iterator var1 = AbstractDungeon.getCurrRoom().monsters.monsters.iterator();

        while(var1.hasNext()) {
            AbstractMonster m = (AbstractMonster)var1.next();
            if (!m.isDeadOrEscaped() && !(m.getIntentBaseDmg() >= 0)) {
                this.glowColor = AbstractCard.GOLD_BORDER_GLOW_COLOR.cpy();
                break;
            }
        }

    }

}
