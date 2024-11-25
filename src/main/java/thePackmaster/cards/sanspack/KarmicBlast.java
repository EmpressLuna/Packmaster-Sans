package thePackmaster.cards.sanspack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.GoldenSlashEffect;
import com.megacrit.cardcrawl.vfx.combat.MindblastEffect;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.atb;

public class KarmicBlast extends AbstractSansCard {
    public final static String ID = makeID("KarmicBlast");

    public KarmicBlast() {
        super(ID, 2, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY);
        baseDamage = 1;
        magicNumber = 20;
        baseMagicNumber = magicNumber;
        isBony = true;
    }

    @Override
    public void upp() {
        upgradeMagicNumber(5);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new VFXAction(p, new MindblastEffect(p.dialogX, p.dialogY, p.flipHorizontal), 0.1F));
        for (int i = 0; i < magicNumber; i++) {
            dmgf(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
        }
    }
}
