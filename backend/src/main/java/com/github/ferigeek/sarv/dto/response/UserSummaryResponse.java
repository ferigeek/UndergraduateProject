package com.github.ferigeek.sarv.dto.response;

import com.github.ferigeek.sarv.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserSummaryResponse {

    private Long id;
    private String username;
    private String displayName;
    private Long profilePictureId;

    public UserSummaryResponse(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.displayName = user.getDisplayName();
        if (user.getProfilePicture() != null) {
            this.profilePictureId = user.getProfilePicture().getId();
        }
    }
}
