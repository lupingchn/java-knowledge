package base.design.pattern.prototype;

import base.design.pattern.builder.Actor;
import base.design.pattern.builder.ActorClient;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangluping on 2018/12/25.
 */
@Slf4j
public class PrototypeClient {

    public static void main(String[] args) {
        Actor actor = ActorClient.builderWithDirector();
        log.info("Prototype actor : {}", actor);
        Actor copyActor = actor.clone();
        copyActor.setHairstyle("黑色短发");
        log.info("Prototype copyActor : {}", copyActor);
        log.info("Prototype actor.costume == copyActor.costume : {}", actor.getCostume() == copyActor.getCostume());

        try {
            Actor deepCopyActor = copyActor.deepClone();
            deepCopyActor.setHairstyle("灰色短发");
            log.info("Prototype deepCopyActor : {}", deepCopyActor);
            log.info("Prototype deepCopyActor.costume == copyActor.costume : {}", deepCopyActor.getCostume() == copyActor.getCostume());
        } catch (Exception e) {
            log.info("Prototype deepCopyActor error : ", e);
        }
    }
}
