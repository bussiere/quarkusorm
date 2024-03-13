package EntityManager;

import EntityObject.Gift;
// import hibernate ApplicationScoped
import jakarta.enterprise.context.ApplicationScoped;
// import hibernate EntityManager
import jakarta.persistence.EntityManager;
// import hibernate Inject
import jakarta.inject.Inject;
// import hibernate Transactional
import jakarta.transaction.Transactional;

@ApplicationScoped
public class SantaClausService {
    @Inject
    EntityManager em;

    @Transactional
    public void createGift(String giftDescription) {
        Gift gift = new Gift();
        gift.setName(giftDescription);
        em.persist(gift);
    }

    // get gift by id
    public Gift getGiftById(Long id) {
        return em.find(Gift.class, id);
    }
}