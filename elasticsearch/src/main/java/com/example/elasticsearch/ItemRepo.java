package com.example.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author weizihan
 */
@Repository
public interface ItemRepo extends ElasticsearchRepository<Item, Long> {
}
