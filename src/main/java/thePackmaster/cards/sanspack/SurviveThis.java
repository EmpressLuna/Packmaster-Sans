package thePackmaster.cards.sanspack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.actions.sanspack.KarmaBasedAttackAction;
import thePackmaster.actions.sanspack.ReverseGravityAction;
import thePackmaster.powers.sanspack.KarmaPower;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.applyToEnemy;

public class SurviveThis extends AbstractSansCard {
    public final static String ID = makeID("SurviveThis");

    public SurviveThis() {
        super(ID, 1, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        damage = 1;
        baseDamage = damage;
        magicNumber = 1;
        baseMagicNumber = magicNumber;
        secondMagic = 3;
        baseSecondMagic = secondMagic;
        isBony = true;
    }

    @Override
    public void upp() {
        upgradeMagicNumber(1);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        int numberOfAttacks = 0;

        if (m.hasPower(KarmaPower.POWER_ID)) {
            flash();
            numberOfAttacks = m.getPower(KarmaPower.POWER_ID).amount;
        }

        for (int i = 0; i < numberOfAttacks * magicNumber; i++) {
            dmgf(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
        }

        applyToEnemy(m, new KarmaPower(m, p, secondMagic));
    }

    public void t(AbstractPlayer p, AbstractMonster m) {

        this.addToBot(new KarmaBasedAttackAction(m, p, magicNumber));
    }
}
