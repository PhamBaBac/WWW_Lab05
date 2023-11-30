package vn.edu.iuh.fit.enums;

import lombok.Getter;

@Getter
public enum SkillLevel {
    MASTER(5),
    BEGINNER(4),
    ADVANCED(3),
    INTERMEDIATE(2),
    PROFESSIONAL(1);
    private final int value;

    SkillLevel(int value) {
        this.value = value;
    }

}
