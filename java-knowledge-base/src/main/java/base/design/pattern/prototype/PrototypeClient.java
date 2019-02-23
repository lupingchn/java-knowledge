package base.design.pattern.prototype;

import base.design.pattern.builder.Character;
import base.design.pattern.builder.CharacterClient;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangluping on 2018/12/25.
 */
@Slf4j
public class PrototypeClient {

    public static void main(String[] args) {
        Character actor = CharacterClient.builderWithDirector();
        log.info("Prototype actor : {}", actor);
        Character copyActor = actor.clone();
        copyActor.setFace("黑色短发");
        log.info("Prototype copyActor : {}", copyActor);
        log.info("Prototype actor.race == copyActor.race : {}", actor.getRace() == copyActor.getRace());

        try {
            Character deepCopyActor = copyActor.deepClone();
            deepCopyActor.setFace("灰色短发");
            log.info("Prototype deepCopyActor : {}", deepCopyActor);
            log.info("Prototype deepCopyActor.race == copyActor.race : {}", deepCopyActor.getRace() == copyActor.getRace());
        } catch (Exception e) {
            log.info("Prototype deepCopyActor error : ", e);
        }
    }
}
