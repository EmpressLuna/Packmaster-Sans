package thePackmaster.cards.sanspack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class Blindside extends AbstractSansCard {
    public final static String ID = makeID("Blindside");

    public Blindside() {
        super(ID, 1, AbstractCard.CardType.ATTACK, AbstractCard.CardRarity.COMMON, AbstractCard.CardTarget.ENEMY);
        baseDamage = 1;
        baseMagicNumber = 7;
    }

    @Override
    public void upp() {
        upgradeMagicNumber(3);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        for (int i = 0; i < magicNumber; i++) {
            dmg(m, AbstractGameAction.AttackEffect.NONE);
        }

        if (m.getIntentBaseDmg() != 0) {
            p.gainEnergy(1);
        }
    }
}
