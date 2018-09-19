package com.digital.cmi.contactms.repository;

import com.digital.cmi.contactms.model.RelatedPartyRef;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelatedPartyRepository extends ElasticsearchRepository<RelatedPartyRef, String> {
}
