package thePackmaster.cards.sanspack;

import com.badlogic.gdx.utils.compression.lz.BinTree;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.util.Wiz;

import java.util.Iterator;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class Blindside extends AbstractSansCard {
    public final static String ID = makeID("Blindside");

    public Blindside() {
        super(ID, 1, AbstractCard.CardType.ATTACK, AbstractCard.CardRarity.COMMON, AbstractCard.CardTarget.ENEMY);
        damage = 1;
        baseDamage = damage;
        magicNumber = 7;
        baseMagicNumber = magicNumber;
        isBony = true;
    }

    @Override
    public void upp() {
        upgradeMagicNumber(3);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        for (int i = 0; i < magicNumber; i++) {
            dmgf(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
        }

        if (m.getIntentBaseDmg() != 0) {
            p.gainEnergy(1);
        }
    }

    public void triggerOnGlowCheck() {
        this.glowColor = AbstractCard.BLUE_BORDER_GLOW_COLOR.cpy();
        Iterator var1 = AbstractDungeon.getCurrRoom().monsters.monsters.iterator();

        while(var1.hasNext()) {
            AbstractMonster m = (AbstractMonster)var1.next();
            if (!m.isDeadOrEscaped() && m.getIntentBaseDmg() >= 0) {
                this.glowColor = AbstractCard.GOLD_BORDER_GLOW_COLOR.cpy();
                break;
            }
        }
    }
}
