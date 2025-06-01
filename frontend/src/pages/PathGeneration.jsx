import { useState } from "react";
import TaskContainer from "../components/TaskContainer";

function PathGeneration() {
    return (
        <div>
            <h1>Your Learning Path</h1>
            <TaskContainer
                title="Learn OOP"
                skill="Programming"
                endDate={"2025-05-05"}/>
            <TaskContainer
                title="Learn about project management"
                skill="Soft skills"
                endDate={"2025-05-05"}/>
        </div>

    )
}

export default PathGeneration