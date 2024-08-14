package com.proyectomicro.MicroEn.models.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.UUID;

@Entity
@EntityScan("org.ibm.models.Entity")
@Data
@Builder
@Generated
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "GCMS_LOG_CATEGORY")

public class LogCategory implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CATEGORY_ID", columnDefinition = "UNIQUEIDENTIFIER")//este
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private UUID categoryId;

    @Column(name = "CATEGORY_NAME", length = 100)//este
    private String categoryName;

    @Column(name = "CATEGORY_DESCRIPTION", length = 200)
    private String categoryDescription;

    @Column(name = "CATEGORY_PARENT", columnDefinition = "UNIQUEIDENTIFIER")//este
    private UUID categoryParent;

    @Column(name = "CATEGORY_LABEL", length = 100)
    private String categoryLabel;

    @Column(name = "CATEGORY_ORDER")
    private Integer categoryOrder;

    @Column(name = "LOG_CODE", length = 100)//este
    private String logCode;

    @Column(name = "COUNTRY_CODE", length = 12)
    private String countryCode;

    @Column(name = "URI_KEY", length = 250)
    private String uriKey;

    @Column(name = "STATUS")
    private Boolean status;

    @Column(name = "PATH_PARAM_VALUE", length = 50)
    private String pathParamValue;

    @Column(name = "CATEGORY_TYPE", length = 8)
    private String categoryType;

    @Column(name = "DISPLAY")
    private Boolean display;

    @Column(name = "REPORT_TYPE_CONFIG", length = 200)
    private String reportTypeConfig;

}
