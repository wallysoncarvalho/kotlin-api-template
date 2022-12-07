package com.wallyson.kotlinapitemplate

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "foobar")
@EntityListeners(AuditingEntityListener::class)
data class FooBar(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null,
    @Column(name = "name")
    val name: String,
    @Column(name = "age")
    val age: Int,
//    @CreatedBy
//    @Column(name = "created_by")
//    var createdBy: String? = null,
    @CreatedDate
    @Column(name = "created_at")
    val createdAt: Instant = Instant.now()
) {
    @CreatedBy
    @Column(name = "created_by")
    var createdBy: String? = null



}