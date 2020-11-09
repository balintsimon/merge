import React from "react";

const ScreenLine = (props) => {

    return (
<img
    src={window.location.origin + "/screenline.png"}
    alt={"Screen here"}
    height="42"
    style={screenLineStyle}
/>
    )
}

export default ScreenLine;

const screenLineStyle = {
    position: "absolute",
    top: "53%",
    left: "49%",
    transform: "translate(-50%, -50%) scale(3)",
    zIndex: "1",
    color: "white",
}