
package com.ecommerce.API_gestion.dto.produit;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProduitRequest {


    @NotBlank(message = "Le nom est obligatoire")
    @Size(min = 3, max = 50, message = "Le nom doit contenir entre 3 et 50 caractères")
    private String nom;

    @NotBlank(message = "La description est obligatoire")
    @Size(min = 10, max = 255, message = "La description doit contenir entre 10 et 255 caractères")
    private String description;

    @NotNull(message = "Le prix est obligatoire")
    @Min(value = 300, message = "Le prix minimal est de 300")
    @Max(value = 50000, message = "Le prix maximal est de 50000")
    private Integer prix;

    @NotNull(message = "Le stock est obligatoire")
    @Min(value = 1, message = "Le stock doit être au minimum 1")
    private Integer stock;

    private String image_url;

    @NotNull(message = "La catégorie est obligatoire")
    private Integer categorie_id;
}
