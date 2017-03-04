package com.sfl.coolmonkey.notifications.persistence.repositories.email;

import com.sfl.coolmonkey.notifications.service.email.model.Email;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 12/17/15
 * Time: 7:38 PM
 */
public interface EmailRepository extends MongoRepository<Email, ObjectId> {
    Email findByUuid(@Nonnull final String uuid);

    List<Email> findByUuidInAndRemovedIsNull(@Nonnull final List<String> uuids);
}
